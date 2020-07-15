package com.ypk.textviewsegment.widget.html;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * @Author: YuanPeikai
 * @CreateDate: 2020/7/15 9:27
 * @Description: 该方法可以（推荐）
 */
public class HtmlUtils {
    public static HtmlUtils instance;
    private Activity activity;
    private TextView text;
    private Drawable pic;
    private String resource;

    private int width;

    private HtmlUtils(Activity activity, TextView text) {
        this.activity = activity;
        this.text = text;

        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        width = outMetrics.widthPixels;

    }

    public static HtmlUtils getInstance(Activity activity, TextView text) {
        if (instance == null) {
            instance = new HtmlUtils(activity, text);
        }
        return instance;
    }

    public void setHtmlWithPic(String resource) {
        this.resource = resource;
        if (Build.VERSION.SDK_INT >= 24)
            text.setText(Html.fromHtml(resource, Html.FROM_HTML_MODE_LEGACY, imageGetter, null));//FROM_HTML_MODE_COMPACT
        else
            text.setText(Html.fromHtml(resource, imageGetter, null));

    }


    Html.ImageGetter imageGetter = new Html.ImageGetter() {
        @Override
        public Drawable getDrawable(String s) {
            if (pic != null) {
                Log.d("TAG", "显示");
                return pic;
            } else {
                Log.d("TAG", "加载" + s);
                getPic(s);
            }
            return null;//优化建议：这里可先返回一个预加载图片
        }
    };

    /**
     * 加载网络图片
     *
     * @param s
     */
    private void getPic(final String s) {

        ImageLoader.getInstance().loadImage(s, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                final Drawable drawable = new BitmapDrawable(activity.getResources(), loadedImage);

                float picW = drawable.getIntrinsicWidth();
                float picH = drawable.getIntrinsicHeight();

                drawable.setBounds(0, 0, width, (int) ((picH / picW) * width));
                pic = drawable;
                if (Build.VERSION.SDK_INT >= 24)
                    text.setText(Html.fromHtml(resource, Html.FROM_HTML_MODE_COMPACT, imageGetter, new DetailTagHandler(activity)));
                else
                    text.setText(Html.fromHtml(resource, imageGetter, new DetailTagHandler(activity)));

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                super.onLoadingFailed(imageUri, view, failReason);
                //这里返回一个加载失败图片
                System.out.println("URLImageParser.onLoadingFailed" + failReason.getCause());
            }
        });



       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Drawable drawable = Drawable.createFromStream(new URL(s).openStream(), "");
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (drawable != null) {
                                WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
                                DisplayMetrics outMetrics = new DisplayMetrics();
                                wm.getDefaultDisplay().getMetrics(outMetrics);
                                float picW = drawable.getIntrinsicWidth();
                                float picH = drawable.getIntrinsicHeight();
                                int width = outMetrics.widthPixels;
                                drawable.setBounds(0, 0, width, (int) ((picH / picW) * width));
                                pic = drawable;
                                if (Build.VERSION.SDK_INT >= 24)
                                    text.setText(Html.fromHtml(resource, Html.FROM_HTML_MODE_COMPACT, imageGetter, null));
                                else
                                    text.setText(Html.fromHtml(resource, imageGetter, null));
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/


    }

}

