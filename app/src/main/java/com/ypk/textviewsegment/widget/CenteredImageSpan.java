package com.ypk.textviewsegment.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;

/**
 * ypk
 * 自定义 TextView 的ImageSpan
 * 能解决text中图标居中对齐问题（无论TextView是否设置行距）
 */
public class CenteredImageSpan extends ImageSpan {

    private int drawableSize, drawableWidth, drawableHeight;

    public CenteredImageSpan(Context context, final int drawableRes) {
        super(context, drawableRes);
    }


    public CenteredImageSpan(Context context, final int drawableRes, int drawableSize) {
        super(context, drawableRes);
        this.drawableSize = drawableSize;
    }

    public CenteredImageSpan(Context context, final int drawableRes, int drawableWidth, int drawableHeight) {
        super(context, drawableRes);
        this.drawableWidth = drawableWidth;
        this.drawableHeight = drawableHeight;
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        // image to draw
        Drawable b = getDrawable();
        //这是drawable的宽和高
        if (drawableSize != 0) {
            b.setBounds(0, 0, drawableSize, drawableSize);
        } else if (drawableWidth != 0 && drawableHeight != 0) {
            b.setBounds(0, 0, drawableWidth, drawableHeight);
        }


        // font metrics of text to be replaced
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int transY = (y + fm.descent + y + fm.ascent) / 2 - b.getBounds().bottom / 2;

        canvas.save();
        canvas.translate(x, transY);
        b.draw(canvas);
        canvas.restore();
    }
}

