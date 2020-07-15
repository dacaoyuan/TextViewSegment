package com.ypk.textviewsegment.widget.html;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.laodao.library.utils.DensityUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * @Author: YuanPeikai
 * @CreateDate: 2020/7/14 16:59
 * @Description: 测试发现这个方法不好使
 */
public class URLImageParser implements Html.ImageGetter {

    TextView mTextView;
    Context context;

    public URLImageParser(Context context, TextView textView) {
        this.mTextView = textView;
        this.context = context;
    }

    @Override
    public Drawable getDrawable(String source) {
        System.out.println("URLImageParser.getDrawable source=" + source);

        //source = "http://image.test.laodao.so/image/course/about/e4eb4de0-bf4b-11ea-972b-7986bdb98d49.png";

        final URLDrawable urlDrawable = new URLDrawable();
        ImageLoader.getInstance().loadImage(source, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                urlDrawable.bitmap = loadedImage;

               /* int width = DensityUtils.Companion.dp2px(context, loadedImage.getWidth());
                int height = DensityUtils.Companion.dp2px(context, loadedImage.getHeight());*/
                int width = loadedImage.getWidth();
                int height = loadedImage.getHeight();
                System.out.println("URLImageParser.onLoadingComplete width=" + width);


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
