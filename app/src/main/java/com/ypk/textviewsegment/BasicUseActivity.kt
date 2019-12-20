package com.ypk.textviewsegment

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.*
import androidx.core.text.HtmlCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.view.View
import androidx.core.content.ContextCompat
import com.ypk.textviewsegment.widget.CenteredImageSpan
import com.ypk.textviewsegment.widget.YpkClickableSpan
import org.sufficientlysecure.htmltextview.HtmlResImageGetter


/**
 *先看一下Spanable中的常用常量：
 *
 *Spanned.SPAN_EXCLUSIVE_EXCLUSIVE --- 不包含start和end所在的端点          (a,b)
 *Spanned.SPAN_EXCLUSIVE_INCLUSIVE --- 不包含端start，但包含end所在的端点  (a,b]
 *Spanned.SPAN_INCLUSIVE_EXCLUSIVE --- 包含start，但不包含end所在的端点   [a,b)
 *Spanned.SPAN_INCLUSIVE_INCLUSIVE--- 包含start和end所在的端点           [a,b]
 */
class BasicUseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
    }


    public fun initView() {

        htmlMethod();

        //字体颜色
        val strContent2 = tv02.text.toString();
        val spannableString2 = SpannableString(strContent2);
        val mForegroundColorSpan = ForegroundColorSpan(Color.BLUE);
        spannableString2.setSpan(mForegroundColorSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv02.text = spannableString2;


        //字体背景颜色
        val strContent3 = tv03.text.toString();
        val spannableString3 = SpannableString(strContent3);
        val mBackgroundColorSpan = BackgroundColorSpan(Color.RED);
        spannableString3.setSpan(mBackgroundColorSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv03.text = spannableString3;


        //字体大小
        val strContent4 = tv04.text.toString();
        val spannableString4 = SpannableString(strContent4);
        val mAbsoluteSizeSpan = AbsoluteSizeSpan(11, true);
        spannableString4.setSpan(mAbsoluteSizeSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv04.text = spannableString4;


        //相对的字体大小，就是字体大小的多少倍
        val strContent5 = tv05.text.toString();
        val spannableString5 = SpannableString(strContent5);
        val mRelativeSizeSpan = RelativeSizeSpan(1.5f);
        spannableString5.setSpan(mRelativeSizeSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv05.text = spannableString5;

        //删除线
        val strContent6 = tv06.text.toString();
        val spannableString6 = SpannableString(strContent6);
        val mStrikethroughSpan = StrikethroughSpan();
        spannableString6.setSpan(mStrikethroughSpan, 2, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv06.text = spannableString6;

        //下划线
        val strContent7 = tv07.text.toString();
        val spannableString7 = SpannableString(strContent7);
        val mUnderlineSpan = UnderlineSpan();
        spannableString7.setSpan(mUnderlineSpan, 2, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv07.text = spannableString7;

        //显示图标,受行间距的影响
        val strContent8 = tv08.text.toString();
        val spannableString8 = SpannableString("  $strContent8");
        val mImageSpan = ImageSpan(this, R.mipmap.ic_huo_yan);
        spannableString8.setSpan(mImageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv08.text = spannableString8;

        //显示图标，不受行间距的影响
        val strContent9 = tv09.text.toString();
        val spannableString9 = SpannableString("  $strContent9");
        val mCenteredImageSpan =
            CenteredImageSpan(this, R.mipmap.ic_huo_yan);
        spannableString9.setSpan(mCenteredImageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv09.text = spannableString9;

        //点击事件
        val strContent10 = tv10.text.toString();
        val spannableString10 = SpannableString(strContent10);
        val clickableSpan = object : YpkClickableSpan() {
            override fun onClick(widget: View) {
                Toast.makeText(application, "ClickableSpan", Toast.LENGTH_LONG).show();
            }
        }
        spannableString10.setSpan(clickableSpan, 2, 13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tv10.movementMethod = LinkMovementMethod.getInstance()//不设置 没有点击事件
        tv10.text = spannableString10;

        //效果叠加
        val strContent11 = tv11.text.toString();
        val spannableString11 = SpannableStringBuilder(strContent11);
        val mForegroundColorSpan11 = ForegroundColorSpan(Color.BLUE);
        spannableString11.setSpan(mForegroundColorSpan11, 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        val mAbsoluteSizeSpan12 = AbsoluteSizeSpan(11, true);
        spannableString11.setSpan(mAbsoluteSizeSpan12, 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv11.text = spannableString11;


    }

    private fun htmlMethod() {
        val strHtmlContent1 =
            "1.分段显示不同颜色<font color='#FF7200'>通过解析HTML来实现</font>" + "关键方法：Html.fromHtml";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            tv01.setText(
                Html.fromHtml(
                    strHtmlContent1,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            )
        } else {
            tv01.setText(Html.fromHtml(strHtmlContent1))
        }

        val strHtmlContent2 =
            "<img src='" + R.mipmap.ic_huo_yan + "'>" + " " + getString(R.string.html2);

        tv011.setText(Html.fromHtml(strHtmlContent2, object : Html.ImageGetter {
            override fun getDrawable(source: String?): Drawable {
                val id = Integer.parseInt(source!!)
                val drawable = ContextCompat.getDrawable(this@BasicUseActivity, id);
                drawable!!.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
                return drawable
            }

        }, null))

        //
        html_text.setHtml(
            "<h2>Hello wold</h2>" + "<ul><li>cats</li><li>dogs</li></ul>" + "<img src=\"ic_huo_yan\"/>",
            HtmlResImageGetter(this@BasicUseActivity)
        );
    }
}
