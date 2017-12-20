package beans;

import db.ProductDb;
import entity.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import util.BinFileUtil;

@Stateless
public class InitProducts {

    @EJB
    ProductDb db;
    String[] name = {"マニキュア", "圧着端子", "コマ", "カラースプーン", "ガラス玉", "パンチ", "ホッチキス", "黒板消し", "透明のボトル", "陶器のフラワー", "ミニチュア門松", "ハニーディッパー", "飾り付きスプーン", "金色の皿", "スモークチップ", "キャンドル", "トレー", "竹のランチョンマット", "基盤", "ハローウィーンの飾り", "工具のパーツ", "コルクボード", "ポケットチーフ", "ご祝儀袋", "ボトルキャップ"
    };
    Integer[] price = {1000, 350, 1500, 280, 450,
        600, 350, 820, 980, 2500,
        1850, 1300, 880, 3200, 1420,
        700, 950, 1100, 1600, 1300,
        330, 1200, 1800, 900, 1000
    };
    AppKind[] kind = {AppKind.KIND3, AppKind.KIND3, AppKind.KIND2, AppKind.KIND1, AppKind.KIND3, AppKind.KIND2, AppKind.KIND1, AppKind.KIND3, AppKind.KIND1,
        AppKind.KIND2, AppKind.KIND2, AppKind.KIND3, AppKind.KIND2, AppKind.KIND2, AppKind.KIND3, AppKind.KIND2, AppKind.KIND2,
        AppKind.KIND1, AppKind.KIND1, AppKind.KIND1, AppKind.KIND3, AppKind.KIND1, AppKind.KIND1, AppKind.KIND3, AppKind.KIND1,};
    String[] text = {"オーピーアイ\n ネイルラッカーでカラーリングし、カラーが乾いた後、このトップコートを使用すると、ビロードの様な柔らかで美しい仕上がりになります。", "●特長： \n" + "端子舌部(接触部)の硬度だけを高めることに成功。\n" + "従来端子に比べ曲がりにくい。  \n" + "●注意： \n" + "※銅線専用です。\n" + "電線抱合範囲内でご使用下さい。\n" + "指定の適用圧着工具をご使用下さい。  ", "こちらが、太田さんの江戸独楽「5点セット」です。\n" + "左上から時計回りに、糸引き独楽、ケンカ独楽、ひねり独楽、二段独楽（上・下）です。", "それぞれの特徴ポイントがイラストとして描かれています。\n" + "お子様やディズニー好きも嬉しい可愛いスプーンです♪\n" + "陶器素材なので口当たりも滑らかな使いやすいスプーンです。", "15mm とんぼ玉 中玉　色玉模様玉 用途色々 ネックレス ブレスレット NO.T2 5点セット ハンドメイド オリジナルアクセサリー ガラス玉 素材 パーツ 緒締め ストラップ かんざし 簪 手作り ガラスビーズ", "大きな型が抜けるメガジャンボクラフトパンチの補助具です。\n" + "小さなお子様や力の弱い方まで、簡単にパンチすることができます。", "2019年1月ボディカラーがリニューアル！\n" + "・綴じ枚数が28枚にグレードアップ！\n" + "・綴じ裏をフラットに綴じる「フラットクリンチ」採用\n" + "　これで書類がかさばりません！\n" + "・予備針を100本収納できます。\n" + "・本体おしりがリムーバーになってます！", "快適・清潔。環境に配慮した、丈夫で使いよいダストレスラーフル。\n" + "粉の飛散を抑える/粉の吸収力効果向上”\n" + "「綾別珍生地」に変わりました。（吸収力約30%UP、当社調べ）", "小さくて可愛い♪けど、厚みのあるしっかりしたガラス瓶です。ビーズや小物入れに☆", "少し青みがかった白は、コーヒータイムを高貴に彩ります。1739年より続くマイセンを代表するシリーズ。中国の染め付け技術を応用してつくられています。", "正月飾り 【レターパック対応】\n" + "正月飾り・ミニ門松◆お正月を華やかにする伝統の縁起物・和小物で新春を祝う◆ちりめん細工　立体門松", "オールビーオリジナルの木製ハニーディッパー。\n" + "先端に入ったハチのイラストの焼印が可愛い便利な一品です。液体の蜂蜜に向いています。ホットケーキやパンなどにはちみつを垂らす時にとても役立ちます。使わない時もカップなどに飾るだけでとてもおしゃれ！小さめなので場所も取りません。プチプライスなのに、蜂蜜に添えるだけで素敵なギフトにもなります。", "ヨーロッパには、「銀のスプーンをくわえて生まれてきた子どもは幸せになる。」という古くから の言い伝えがあって、赤ちゃん誕生のお祝いとして銀のスプーンを贈る習慣があります。\n" + "当店でも人気ランキング堂々１位の商品であり、最近では日本でもご出産のお祝いやお食い初めのギフトとしてポピュラーになっております。", "【iittala（イッタラ）】はガラス製品メーカーとして、1881年に自然豊かな森と湖の国フィンランドで生まれました。\n" + "国内外の著名なデザイナーたちと、時代を超えて愛される商品を生み出してきました。", "・個性的な強い香りでどんな食材にもマッチします\n" + "袋サイズ（約）：200×280mm　\n" + "適用品種：燻製器（共通）　\n" + "主成分：原木／サクラ　\n" + "重量（約）：0.5kg　\n" + "生産国：日本", "インテリア/照明/キャンドル/防災/エコ/flamelesscandles/フレイムレスキャンドル/イコビス/mothersday\n" + "Candle impressions キャンドルインプレッションズ FLAMELESS CANDLES フレイムレスキャンドル LEDキャンドル Type G ", "お客様へのおもてなしを美しく上品に演出する半月膳\n" + "片面は黒塗り、もう片面は朱塗りになっています。黒面には木目の模様、赤面には布目の模様が入っています。", "1mmほどの細い竹ひごで作られたランチョンマットは、落ち着いた雰囲気の食卓演出して頂けます。また、雑貨やインテリアを飾る際に敷いてお使い頂くこともできます。", "【商品説明】\n" + "車種専用設計 純正基盤打ち替えLEDキット\n" + "安心の当社オリジナルマニュアル付き\n" + "\n" + "失敗時用の予備ＬＥＤ入り\n" + "内装照明をトータルゴーディネート\n" + "\n" + "※注意事項に記載の【事前にご用意頂く物】をご確認の上、ご注文下さい。", "かぼちゃ/パンプキン/おばけ/ハロウィン(ハロイン/ハローウィン/Halloween)\n" + "・プレゼント(ぬいぐるみクマ付)のラッピングに。かわいいぬいぐるみ付のタイ/飾り)\n" + "・包材/簡易包装/使い捨て/店舗備品\n", "作業場所に合わせて、2段階にポジションチェンジが出来るドライバー。\n" + "正転／逆転スイッチで簡単にネジ締め・取り外しが可能。\n" + "ドライバービットを本体に収納出来るので、素早く簡単にビット交換出来ます。", "コルクボード　タテ６００×ヨコ９００ｍｍ【HLS_DU】【1thr】★5000円以上お買上げポイント10倍【期間:6/25(水)10:00～6/27(金)9:59】【ポイント付与8/20頃】 ", "鹿児島さんのイラストを\n" + "木版でプリントしたハンカチ。\n" + "インドの工場で\n" + "一つ一つ手作業で作られています。\n" + "\n" + "職人さんの手彫りによるパーツを使って\n" + "色ごとに版を押していく\n" + "｢ブロックプリント｣という\n" + "手間のかかる染色方法が用いられています。", "色彩の美しさを楽しめる金封。シワ加工を施したピンク紙に映えるゴールドの水引が存在感を醸し出しています。代書・代筆無料\n" + "レビュー記入でメール便送料無料\n" + "1～3万円に最適 5030-66\n" + "【結婚 御祝 祝儀袋 金封】 ", "ペットボトルのリユースと\n" + "\n" + "使う人にやさしい機能を備えた\n" + "\n" + "ハート型の付け替えキャップです。\n" + "\n" + "通常のキャップより、握りやすく\n" + "\n" + "開けやすい形になっています。\n" + "\n" + "バックからのぞくハートは、\n" + "\n" + "ファッションのアクセントになります。\n" + "\n" + "気になるカラーはなんと全13色。\n" + "\n" + "地球とあなたに優しいECOな\n" + "\n" + "ボトルキャップです"
    };

    String[] urlS = {"/resources/images/S01.jpg", "/resources/images/S02.jpg", "/resources/images/S03.jpg", "/resources/images/S04.jpg", "/resources/images/S05.jpg",
        "/resources/images/S06.jpg", "/resources/images/S07.jpg", "/resources/images/S08.jpg", "/resources/images/S09.jpg", "/resources/images/S10.jpg",
        "/resources/images/S11.jpg", "/resources/images/S12.jpg", "/resources/images/S13.jpg", "/resources/images/S14.jpg", "/resources/images/S15.jpg",
        "/resources/images/S16.jpg", "/resources/images/S17.jpg", "/resources/images/S18.jpg", "/resources/images/S19.jpg", "/resources/images/S20.jpg",
        "/resources/images/S21.jpg", "/resources/images/S22.jpg", "/resources/images/S23.jpg", "/resources/images/S24.jpg", "/resources/images/S25.jpg",};

    String[] urlL = {"/resources/images/L01.jpg", "/resources/images/L02.jpg", "/resources/images/L03.jpg", "/resources/images/L04.jpg", "/resources/images/L05.jpg",
        "/resources/images/L06.jpg", "/resources/images/L07.jpg", "/resources/images/L08.jpg", "/resources/images/L09.jpg", "/resources/images/L10.jpg",
        "/resources/images/L11.jpg", "/resources/images/L12.jpg", "/resources/images/L13.jpg", "/resources/images/L14.jpg", "/resources/images/L15.jpg",
        "/resources/images/L16.jpg", "/resources/images/L17.jpg", "/resources/images/L18.jpg", "/resources/images/L19.jpg", "/resources/images/L20.jpg",
        "/resources/images/L21.jpg", "/resources/images/L22.jpg", "/resources/images/L23.jpg", "/resources/images/L24.jpg", "/resources/images/L25.jpg",};

    public void init() {
        for (int i = 0; i < name.length; i++) {
            byte[] pic1 = BinFileUtil.getBinary(urlS[i]);
            byte[] pic2 = BinFileUtil.getBinary(urlL[i]);
            Product product = new Product(name[i], price[i], kind[i], text[i], pic1, pic2);
            db.add(product);
        }

    }
}
