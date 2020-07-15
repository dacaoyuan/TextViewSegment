package com.ypk.textviewsegment.widget.html;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.laodao.library.utils.BitmapUtil;
import com.laodao.library.utils.DensityUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.ypk.textviewsegment.R;
import com.ypk.textviewsegment.utils.BitmapUtils;

/**
 * @Author: YuanPeikai
 * @CreateDate: 2020/7/14 16:59
 * @Description: 测试发现这个方法好使（推荐）
 */
public class URLImageParser implements Html.ImageGetter {

    TextView mTextView;
    Context context;
    int width;

    public URLImageParser(Context context, TextView textView) {
        this.mTextView = textView;
        this.context = context;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        width = outMetrics.widthPixels;
    }

    @Override
    public Drawable getDrawable(String source) {
        System.out.println("URLImageParser.getDrawable source=" + source);


        if (source.startsWith("http")) {
            final URLDrawable urlDrawable = new URLDrawable();
            ImageLoader.getInstance().loadImage(source, new SimpleImageLoadingListener() {
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    float picH = loadedImage.getHeight();
                    float picW = loadedImage.getWidth();
                    System.out.println("URLImageParser.onLoadingComplete picW=" + picW + " picH =" + picH);
                    loadedImage = BitmapUtils.zoomImg(loadedImage, width, (int) ((picH / picW) * width));
                    urlDrawable.bitmap = loadedImage;

                    int width = loadedImage.getWidth();
                    int height = loadedImage.getHeight();
                    System.out.println("URLImageParser.onLoadingComplete width=" + width);
                    System.out.println("URLImageParser.onLoadingComplete height=" + height);
                    urlDrawable.setBounds(0, 0, width, height);
                    mTextView.invalidate();
                    mTextView.setText(mTextView.getText());


                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    super.onLoadingFailed(imageUri, view, failReason);
                    System.out.println("URLImageParser.onLoadingFailed" + failReason.getCause());
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    super.onLoadingCancelled(imageUri, view);
                    System.out.println("URLImageParser.onLoadingCancelled");
                }
            });
            return urlDrawable;
        } else {
            // urlDrawable.bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_huo_yan);
            int id = Integer.parseInt(source);
            //Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_solid_red_oval);
            Drawable drawable = ContextCompat.getDrawable(context, id);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }

    }


    public class URLDrawable extends BitmapDrawable {
        protected Bitmap bitmap;


        @Override
        public void draw(Canvas canvas) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0, 0, getPaint());
            }
        }
    }

}
