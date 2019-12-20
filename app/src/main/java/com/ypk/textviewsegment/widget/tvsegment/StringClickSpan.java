package com.ypk.textviewsegment.widget.tvsegment;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * @author YuanPeikai
 * @Package
 * @Description: $description
 * @date 2019/12/20 14:59
 */
public class StringClickSpan extends ClickableSpan {
    String string;
    Context context;
    int color;
    boolean is_underline = true;
    ClickCallBack clickCallBack;



    public StringClickSpan(Context context, int color, boolean is_underline, ClickCallBack clickCallBack) {
        this.context = context;
        this.color = color;
        this.is_underline = is_underline;
        this.clickCallBack = clickCallBack;
    }

    public StringClickSpan(String str, Context context, int color, ClickCallBack clickCallBack) {
        this.string = str;
        this.context = context;
        this.color = color;
        this.clickCallBack = clickCallBack;
    }

    public StringClickSpan(Context context, int color, ClickCallBack clickCallBack) {
        this.context = context;
        this.color = color;
        this.clickCallBack = clickCallBack;
    }

    @Override
    public void onClick(View widget) {
        if (clickCallBack != null) {
            clickCallBack.onStringClick(widget);
        }
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        if (!is_underline) {
            ds.setUnderlineText(false);
        }
        ds.setColor(color);
    }

    public interface ClickCallBack {
        void onStringClick(View view);
    }

}
