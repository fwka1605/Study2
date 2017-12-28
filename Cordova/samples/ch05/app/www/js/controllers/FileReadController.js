(function(){

    function FilePropsController($scope){
        $scope.file = cordova.file;
        console.log(cordova.file.applicationDirectory);
    };

    /**
     * ディレクトリの読込
     * @param $scope
     * @constructor
     */
    function DirReadController($scope){

        $scope.files = [];

        // (1) URLを指定
        window.resolveLocalFileSystemURL(
            cordova.file.applicationDirectory + "www",

            // (2) Entry(DirectoryEntry)の取得に成功した場合
            function(entry){
                // (3) ファイル一覧を取得する処理
                var reader = entry.createReader();
                reader.readEntries(function(entries){
                    // (4) $applyはAngularJSに変更を伝える為
                    $scope.$apply(function(){
                        //  指定したディレクトリ以下のファイル、もしくはディレクトリの一覧が取得できる
                        $scope.files = entries;
                    });
                },function(error){
                    window.alert("読込失敗 :" + error.code);
                });
            },
            // (5) 失敗した場合
            function(error){
                var message = "unknown";
                switch(error.code){
                    case FileError.NOT_FOUND_ERR:
                        message = "ファイルが見つかりません";
                        break;
                    default:
                        message = "その他エラー";
                        break;
                }
                window.alert("読込失敗 :" + error.code + " - " + message);
            }
        );
    }

    function FileReadController($scope){

        $scope.text = "";

        // (1) FileEntryを取得する
        window.resolveLocalFileSystemURL(
            cordova.file.applicationDirectory + "www/json/labels.json",
            function(entry){

                // (2) Fileオブジェクトを取得する
                entry.file(function(file){
                    // (3) FileReaderを使って内容を読む
                    var reader = new FileReader();
                    reader.onload = function(e){
                        $scope.$apply(function(){
                            $scope.text = e.target.result;
                        })
                    };
                    //  (4) テキストとしてデータを読みこむ
                    reader.readAsText(file);
                });
            },
            function(error){
                window.alert("読込失敗 :" + error.code + " - " + message);
            }
        );
    }

    var module = angular.module('cdv.file.read.controllers',[]);
    module.controller('FilePropsController',['$scope',FilePropsController]);
    module.controller('DirReadController',['$scope',DirReadController]);
    module.controller('FileReadController',['$scope',FileReadController]);
}());
