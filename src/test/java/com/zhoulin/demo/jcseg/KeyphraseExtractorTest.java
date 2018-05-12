package com.zhoulin.demo.jcseg;



import com.jcseg.extractor.impl.TextRankKeyphraseExtractor;
import com.jcseg.tokenizer.core.*;
import com.zhoulin.demo.DemoApplicationTests;
import com.zhoulin.demo.service.InfoService;
import com.zhoulin.demo.service.JcsegService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class KeyphraseExtractorTest extends DemoApplicationTests {

    @Autowired
    private JcsegService jcsegService;

    @Autowired
    private InfoService infoService;


    public static void main(String[] args) 
    {
        //create your JcsegTaskConfig here please
        JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setClearStopwords(true);
        config.setAppendCJKSyn(false);
        config.setEnSecondSeg(false);
        config.setKeepUnregWords(false);
        ADictionary dic = DictionaryFactory.createSingletonDictionary(config);
        
        try {
            ISegment seg = SegmentFactory
                    .createJcseg(JcsegTaskConfig.COMPLEX_MODE, new Object[]{config, dic});
            
            TextRankKeyphraseExtractor extractor = new TextRankKeyphraseExtractor(seg);
            extractor.setMaxIterateNum(10);
            extractor.setWindowSize(5);
            extractor.setKeywordsNum(15);
            extractor.setMaxWordsNum(4);
            //extractor.setAutoMinLength(4);
            
            List<String> phrases;

            String doc = "新榜连续2年全国公众号总排名前5 欢迎转载，须署名并注明来自占豪微信，否则追究法律责任。  特朗普治国有多随意？4月9日美国美国政治类网络媒体Axios爆出猛料：之前特朗普在中国清明节假期突然宣布要再对1000亿美元中国产品加征关税的相关决定，根本没有与任何幕僚商量，而是自己突然心血来潮拍脑门的结果！  我勒个天！如果美国真的要再对中国追加1000亿美元的商品征税，那不仅仅意味着贸易战的升级，更意味着中美之间的贸易关系将会受到重创，中美贸易战的规模将立刻上升两个量级，非常危险！当今世界，中美关系是世界上最重要的双边关系。美俄斗成那样，世界都没有乱，但如果中美关系进一步因为特朗普的政策严重恶化，那么全世界都将受到严重威胁，这一切都是因为中国经济的规模太大了，中国经济的影响力太大了！  然而，这么大的事，特朗普和任何人都没商量，直接就宣布了！  这家媒体写道：   “白宫里没有召开过哪怕一次会议去探讨这个史上最狠的威胁会有什么好处和坏处，特朗普甚至都没有和他的首席经济顾问库德洛咨询过此事，就直接把他的计划以既定事实的口吻公布了……”  甚至，这件事连白宫幕僚长在事前都没有听说过。由此可见，特朗普施政的随意性和独断性，而这恐怕也是特朗普的重要幕僚一个个辞职的根本原因之一。而从最近的情况看，甚至连他的女儿、女婿都有些噤声了。接下来，相信特朗普的施政还将具有这样的问题，那么大概率还是会有幕僚不断从他的麾下辞职！  然而，现在的问题是，美国接下来怎么办？是继续公布一千亿美元的商品清单？还是对中国进行妥协，放下姿态与中国展开平等互利的谈判？当然，如果美国没有做好向中国出口高科技产品的准备，又有什么资格要求中国在关税上对美国予以照顾呢？  现在，被架在火上烤的是白宫，是特朗普！在没有台阶下的情况下，难道找叙利亚和普京的茬就是好的金蝉脱壳之计吗？  朗普：赶紧坐下吧号主，都被你说中我就没法混了！  点赞、分享，是最好的支持！  占豪系列作品签名版长按二维码订购  战友临走点下方留个手印。如觉文章不错，转发亲朋让大家看到咱的中国立场。 思考者在阅读，点击下面链接查阅 贸易战被中国怼懵了，美国要打击叙利亚普京下令反击！ 博鳌中国拱手迎客，却对美迎面一锤，留给特朗普的时间不多了！ 外交部狠怼美国一把又亮了！特朗普最新意图在推特曝光！ 特朗普突然发推谈贸易战，释放强烈信号！ 刚刚，美国软肋彻底暴露！这次中国要狠狠打，把特朗普打回谈判桌！ 特朗普再甩千亿，欧日也想捅刀中国？不惜一切代价，打退来犯之敌！ 惹毛雄起中国！特朗普，你这次真要“掉得大”！ 狠狠打！打出30年经济和平！中国直击美国要害！ 贸易战逼中俄联手！中东终于捂不住了，一夜大乱！ 中美贸易战，最倒霉的竟是他们，你绝对想不到！ 强力实锤反击，中国对美加关税！中国打赢这场贸易战，能得到什么，会损失什么？ 中美贸易战，原来有大秘密，中国为何必须打赢？ 中国放的这句狠话，美国再听不懂就要出大事了！ 中国反击又一重锤！人民币代替美元结算，真是拳拳到肉！ 神秘而重磅的访问，他向世界释放7大信号！（文末大福利） 辽宁舰与至少40艘舰南海军演，中国展示势将贸易战打到底的决心！ 中国这记重锤，让美国内伤！上海原油期货上市，意义重磅！ 中美贸易战，美国必败的3大原因在此！ 中国已反击美国！贸易战，中国５招制敌！ 中美贸易战背后，是特朗普中东大阴谋！ 特朗普炮轰中国，贸易战找错对象，白宫犯三大战略性错误！ ";

            phrases = extractor.getKeyphraseFromString(doc);

//            phrases = extractor.getKeyphraseFromString("支持向量机广泛应用于文本挖掘，例如，"
//                    + "基于支持向量机的文本自动分类技术研究一文中很详细的介绍支持向量机的算法细节，"
//                    + "文本自动分类是文本挖掘技术中的一种！");
            //phrases = extractor.getKeyphraseFromFile("/home/chenxin/curpos/5.txt");
            System.out.println(phrases);
        } catch (JcsegException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jcesegTest(){
        String doc = "阿里巴巴 学生 学生 是大大是";

        try {
            List<String> phrase =  jcsegService.getKeywordsphrase(doc);
            for (String p: phrase) {
                System.out.println("!!" + p);
            }

            System.out.println(phrase.get(0) );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getHotWordsTest(){

        try {
            List<String> phrase = infoService.getHotWords();
            System.out.println("!!!" + phrase);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
