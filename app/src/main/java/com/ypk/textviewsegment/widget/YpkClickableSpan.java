package com.ypk.textviewsegment.widget;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

public class YpkClickableSpan extends ClickableSpan {


    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
       // super.updateDrawState(ds);
        ds.setColor(Color.BLUE);
        ds.setUnderlineText(false);
    }

    @Override
    public void onClick(@NonNull View widget) {

    }
}
