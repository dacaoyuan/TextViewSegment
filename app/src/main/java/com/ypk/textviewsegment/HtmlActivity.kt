package com.ypk.textviewsegment

import android.os.Build
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ypk.textviewsegment.widget.html.HtmlUtils
import kotlinx.android.synthetic.main.activity_html.*
import kotlinx.android.synthetic.main.activity_main.*

class HtmlActivity : AppCompatActivity() {


    val strHtml =
        "<table class=\"pci_c\" width=\"400\" style=\"width: 646px; margin-right: auto; margin-left: auto; color: rgb(15, 15, 15); font-family: &quot;Microsoft Yahei&quot;; font-size: 12px;\"><tbody><tr><td align=\"center\"><img src=\"http://paper.people.com.cn/rmrb/images/1/20200708/1594151557136_1.jpg\"></td></tr><tr><td><p style=\"margin-top: 25px; margin-bottom: 25px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32.4px; text-indent: 0em; color: rgb(34, 34, 34);\">　　7日，武警湖北总队黄冈支队官兵紧急转移受困人员。<br>　　谢定安摄（影像中国）</p></td></tr></tbody></table><table class=\"pci_c\" width=\"400\" style=\"width: 646px; margin-right: auto; margin-left: auto; color: rgb(15, 15, 15); font-family: &quot;Microsoft Yahei&quot;; font-size: 12px;\"><tbody><tr><td align=\"center\"><img src=\"http://paper.people.com.cn/rmrb/images/1/20200708/1594151563146_1.jpg\"></td></tr></tbody></table>\n";

    // val strHtml ="<font color=\"#167efb\" size=\"4\"><b><u>加强栽培管理工作，在龙眼荔枝的各次新梢期，合理施肥，促进新梢抽发整齐健壮，缩短适宜三角新小卷蛾的成虫产卵、繁殖所需的梢龄期，以减轻为害。</u></b></font><br>"


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

        /* mTextView.setText(
             Html.fromHtml(
                 strHtml,
                 Html.FROM_HTML_MODE_LEGACY, URLImageParser(this, mTextView), null
             )
         )*/
        HtmlUtils.getInstance(this, mTextView).setHtmlWithPic(strHtml)
        mTextView.movementMethod = LinkMovementMethod.getInstance()//不设置 点击事件不生效

    }

    override fun onDestroy() {
        super.onDestroy()
        HtmlUtils.instance = null
    }
}
