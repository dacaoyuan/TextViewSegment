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
import com.ypk.textviewsegment.widget.html.URLImageParser
import kotlinx.android.synthetic.main.activity_html.*

class HtmlActivity : AppCompatActivity() {


    //var strHtml = "<table class=\"pci_c\" width=\"400\" style=\"width: 646px; margin-right: auto; margin-left: auto; color: rgb(15, 15, 15); font-family: &quot;Microsoft Yahei&quot;; font-size: 12px;\"><tbody><tr><td align=\"center\"><img src=\"http://paper.people.com.cn/rmrb/images/1/20200708/1594151557136_1.jpg\"></td></tr><tr><td><p style=\"margin-top: 25px; margin-bottom: 25px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32.4px; text-indent: 0em; color: rgb(34, 34, 34);\">　　7日，武警湖北总队黄冈支队官兵紧急转移受困人员。<br>　　谢定安摄（影像中国）</p></td></tr></tbody></table><table class=\"pci_c\" width=\"400\" style=\"width: 646px; margin-right: auto; margin-left: auto; color: rgb(15, 15, 15); font-family: &quot;Microsoft Yahei&quot;; font-size: 12px;\"><tbody><tr><td align=\"center\"><img src=\"http://paper.people.com.cn/rmrb/images/1/20200708/1594151563146_1.jpg\"></td></tr></tbody></table>\n";

    var strHtml =
        "<div style=\"text-align: center;\">加强栽培管理工作，在龙眼荔枝的各次新梢期，合理施肥，促进新梢抽发整齐健壮，缩短适宜三角新小卷蛾的成虫产卵、繁殖所需的梢龄期，以减轻为害。</div>"

    //var strHtml ="<div class=\\\"para\\\" label-module=\\\"para\\\" style=\\\"overflow-wrap: break-word; margin-bottom: 15px; text-indent: 28px; line-height: 24px; zoom: 1;\\\"><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">樱花（学名：</span><i style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">Cerasus&nbsp;</i><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">sp.）：是</span><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(176, 111, 187);\\\"><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E8%94%B7%E8%96%87%E7%A7%91\\\" style=\\\"\\\">蔷薇科</a><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E6%A8%B1%E5%B1%9E\\\" style=\\\"\\\">樱属</a></span><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">几种</span><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E6%A4%8D%E7%89%A9\\\" style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(19, 110, 194);\\\">植物</a><span style=\\\"font-family: arial, 宋体, sans-serif;\\\"><span style=\\\"color: rgb(51, 51, 51);\\\">的统称，在我国古代樱花与</span><span style=\\\"font-size: large; color: rgb(57, 181, 74);\\\">樱桃是不分</span><span style=\\\"color: rgb(51, 51, 51);\\\">的；</span></span><span class=\\\"sup--normal\\\" data-sup=\\\"1\\\" data-ctrmap=\\\":1,\\\" style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 102, 204); font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; cursor: pointer; padding: 0px 2px;\\\">&nbsp;[1]</span><a class=\\\"sup-anchor\\\" name=\\\"ref_[1]_10489389\\\" style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\\\">&nbsp;</a><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">&nbsp;《</span><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E6%A4%8D%E7%89%A9%E5%BF%97\\\" style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(255, 138, 0);\\\">中国植物志</a><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">》新修订的名称中专指“</span><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E4%B8%9C%E4%BA%AC%E6%A8%B1%E8%8A%B1\\\" style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(19, 110, 194);\\\">东京樱花</a><span style=\\\"color: rgb(51, 51, 51);\\\"><span style=\\\"font-family: arial, 宋体, sans-serif;\\\">”，亦称</span><span style=\\\"font-family: 楷体;\\\">“</span></span><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E6%97%A5%E6%9C%AC%E6%A8%B1%E8%8A%B1\\\" style=\\\"color: rgb(19, 110, 194); font-family: 楷体; font-weight: bold;\\\">日本樱花</a><span style=\\\"font-family: arial, 宋体, sans-serif; color: rgb(51, 51, 51);\\\">”。樱花品种相当繁多，数目超过</span><span style=\\\"color: rgb(51, 51, 51); font-family: 黑体;\\\">三百种，</span><span style=\\\"font-family: Verdana; color: rgb(255, 138, 0);\\\">全世界共有野生樱花约150种</span><span style=\\\"color: rgb(51, 51, 51); font-family: 黑体;\\\">，中国有</span><span style=\\\"font-family: 黑体; color: rgb(176, 111, 187);\\\">50</span>  <span  style=\\\"color: rgb(51, 51, 51); font-family: 楷体; font-weight: bold; font-style: italic;\\\">有33种。其他的则是通过<a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E5%9B%AD%E8%89%BA\\\" style=\\\"color: rgb(19, 110, 194);\\\">园艺</a><a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E6%9D%82%E4%BA%A4\\\" style=\\\"color: rgb(19, 110, 194);\\\">杂交</a>所衍生得到的品种。</span></div><div class=\\\"para\\\" label-module=\\\"para\\\" style=\\\"overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 28px; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\\\">樱花原产北半球温带环<a target=\\\"_blank\\\" href=\\\"https://baike.baidu.com/item/%E5%96%9C%E9%A9%AC%E6%8B%89%E9%9B%85%E5%B1%B1\\\" style=\\\"color: rgb(19, 110, 194);\\\">喜马拉雅山</a>地区，在世界各地都有生长，主要在日本国生长。花每枝3到5朵，成伞状花序，花瓣先端缺刻，花色多为白色、粉红色。花常于3月与叶同放或叶后开花，随季节变化，樱花花色幽香艳丽，常用于园林观赏。樱花可分单瓣和复瓣两类，单瓣类能开花结果，复瓣类多半不结果。</div>\n";
    //var strHtml = "<font color=\"#167efb\" size=\"4\"><b><u>加强栽培管理工作，在龙眼荔枝的各次新梢期，合理施肥，促进新梢抽发整齐健壮，缩短适宜三角新小卷蛾的成虫产卵、繁殖所需的梢龄期，以减轻为害。</u></b></font><br>"

    // var strHtml ="ddddd"
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

        /* mTextView.setText(
             Html.fromHtml(strHtml,Html.FROM_HTML_MODE_COMPACT)
         )*/

        strHtml = "<img src='" + R.drawable.ic_solid_transparent + "'>" + strHtml;
        val fromHtml: Spanned = Html.fromHtml(
            strHtml,
            Html.FROM_HTML_MODE_LEGACY, URLImageParser(this, mTextView), DetailTagHandler(this)
        )
        mTextView.setText(
            fromHtml
        )

       /* val mStr = SpannableString("  " + strHtml);
        val mCenteredImageSpan = CenteredImageSpan(this, R.mipmap.ic_huo_yan);
        mStr.setSpan(mCenteredImageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.setText(
            mStr
        )*/


        //HtmlUtils(this, mTextView).setHtmlWithPic(strHtml)


        mTextView.movementMethod = LinkMovementMethod.getInstance()//不设置 点击事件不生效

    }


}
