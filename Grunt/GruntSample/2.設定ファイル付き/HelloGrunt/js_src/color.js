// jQueryの初期化処理
$(function(){
    // ボタンハンドラ
    $("#random-color").on("click", function(){
        // 背景色を変更
        randomBackColor();
    });
    
    /**
     * 背景色を変更
     */
    var randomBackColor = function(){
        // RGBをランダムに生成
        var randomRed   = Math.floor(Math.random() * 255);
        var randomGreen = Math.floor(Math.random() * 255);
        var randomBlue  = Math.floor(Math.random() * 255);
        
        // 背景色のCSS設定値を生成
        var cssBackground 
        = "rgb(" + randomRed + "," + randomGreen + "," + randomBlue + ")";
        
        // 背景色を設定
        $("body").css("background-color", cssBackground);
    };
});