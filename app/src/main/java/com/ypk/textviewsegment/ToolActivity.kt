package com.ypk.textviewsegment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.ypk.textviewsegment.utils.DensityUtils
import com.ypk.textviewsegment.widget.YpkClickableSpan
import com.ypk.textviewsegment.widget.tvsegment.StringClickSpan
import kotlinx.android.synthetic.main.activity_tool.*

class ToolActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool)

        initView();
    }

    private fun initView() {
        textView1.setSpecifiedTextsColor(
            "为确认身份，我们需要验证您的手机号。请使用安全手机18865526389获取验证码短信",
            "18865526389",
            ContextCompat.getColor(this, R.color.colorAccent),
            false,
            object : StringClickSpan.ClickCallBack {
                override fun onStringClick(view: View?) {
                    Toast.makeText(this@ToolActivity, "点击了手机号", Toast.LENGTH_LONG).show()
                }
            })

        textView2.setSpecifiedTextsColor(
            "为确认身份，我们需要验证您的手机号。请使用安全手机 18865526389 获取验证码短信",
            " 18865526389 ",
            ContextCompat.getColor(this, R.color.colorAccent)
        )
        textView3.setSpecifiedTextsSize(
            "¥ 99.65",
            " 99.65", DensityUtils.sp2px(this, 25f)

        )

        textView4.setSpecifiedPositionIcon(
            "马云马化腾对决交通场景一文说清双方布局,马云马化腾对决交通场景一文说清双方布局",
            10,
            R.mipmap.ic_huo_yan
        )

        textView5.setTextHeadIcon(
            "马云马化腾对决交通场景一文说清双方布局,马云马化腾对决交通场景一文说清双方布局",
            R.mipmap.ic_huo_yan
        )
        textView6.setTextEndIcon(
            "马云马化腾对决交通场景一文说清双方布局,马云马化腾对决交通场景一文说清双方布局",
            R.mipmap.ic_huo_yan
        )

    }
}
