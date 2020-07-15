package com.ypk.textviewsegment

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ypk.textviewsegment.widget.CenteredImageSpan
import com.ypk.textviewsegment.widget.html.DetailTagHandler
import com.ypk.textviewsegment.widget.html.HtmlUtils
import com.ypk.textviewsegment.widget.html.URLImageParser
import kotlinx.android.synthetic.main.activity_html.*
import kotlinx.android.synthetic.main.activity_main.*

class HtmlActivity : AppCompatActivity() {


    var strHtml =
        "<table class=\"pci_c\" width=\"400\" style=\"width: 646px; margin-right: auto; margin-left: auto; color: rgb(15, 15, 15); font-family: &quot;Microsoft Yahei&quot;; font-size: 12px;\"><tbody><tr><td align=\"center\"><img src=\"http://paper.people.com.cn/rmrb/images/1/20200708/1594151557136_1.jpg\"></td></tr><tr><td><p style=\"margin-top: 25px; margin-bottom: 25px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32.4px; text-indent: 0em; color: rgb(34, 34, 34);\">　　7日，武警湖北总队黄冈支队官兵紧急转移受困人员。<br>　　谢定安摄（影像中国）</p></td></tr></tbody></table><table class=\"pci_c\" width=\"400\" style=\"width: 646px; margin-right: auto; margin-left: auto; color: rgb(15, 15, 15); font-family: &quot;Microsoft Yahei&quot;; font-size: 12px;\"><tbody><tr><td align=\"center\"><img src=\"http://paper.people.com.cn/rmrb/images/1/20200708/1594151563146_1.jpg\"></td></tr></tbody></table>\n";

    //var strHtml = "<font color=\"#167efb\" size=\"4\"><b><u>加强栽培管理工作，在龙眼荔枝的各次新梢期，合理施肥，促进新梢抽发整齐健壮，缩短适宜三角新小卷蛾的成虫产卵、繁殖所需的梢龄期，以减轻为害。</u></b></font><br>"

    // var strHtml ="ddddd"
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

        strHtml = "<img src='" + R.drawable.ic_solid_red_trans + "'>" + strHtml;
        val fromHtml: Spanned = Html.fromHtml(
            strHtml,
            Html.FROM_HTML_MODE_LEGACY, URLImageParser(this, mTextView), DetailTagHandler(this)
        )
        mTextView.setText(
            fromHtml
        )

        /*val mStr = SpannableString("  " + fromHtml);
        val mCenteredImageSpan = CenteredImageSpan(this, R.mipmap.ic_huo_yan);
        mStr.setSpan(mCenteredImageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.setText(
            mStr
        )*/


        //HtmlUtils(this, mTextView).setHtmlWithPic(strHtml)


        mTextView.movementMethod = LinkMovementMethod.getInstance()//不设置 点击事件不生效

    }


}
