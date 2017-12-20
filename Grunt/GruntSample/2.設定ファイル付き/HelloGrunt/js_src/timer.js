// jQueryの初期化処理
$(function(){
    // setIntervalのID
    var intervalID = null;
    
    // ボタンハンドラ
    $("#toggle-timer").on("click", function(){
        // タイマーが実行されていない場合はタイマー開始
        if (intervalID == null) {
            startTimer();
        }
        // タイマー実行中の場合はタイマー終了
        else {
            stopTimer();
        }
    });
    
    /**
     * タイマー開始
     */
    var startTimer = function(){
        if (intervalID == null) {
            intervalID = setInterval(function(){
                $("#now-time").text(new Date().toLocaleString());
            }, 1000);
        }
    };
    
    /**
     * タイマー終了
     */
    var stopTimer = function(){
        if (intervalID != null) {
            clearInterval(intervalID);
            intervalID = null;
        }
    };
});