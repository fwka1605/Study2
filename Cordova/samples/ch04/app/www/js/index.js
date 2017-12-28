(function(){
    // (1) 準備が完了したときの処理
    document.addEventListener('deviceready', function(){
        // (2) 準備完了後、AngularJSを起動する
        angular.bootstrap(document,["main"]);
    }, false);
}());