(function () {

    function FileWriteController($scope) {

        $scope.save = function () {
            // (1) textareaで設定された文字列
            var input = $scope.input;

            window.resolveLocalFileSystemURL(
                cordova.file.dataDirectory,
                function(dir){
                    // (2) memo.txtファイルがない場合には作成する
                    dir.getFile("memo.txt", {create: true}, function (entry) {
                        // (3) FileWriterオブジェクトを作成する
                        entry.createWriter(function (writer) {
                            // (4) ファイルを追記する場合
                            // writer.seek(writer.length);

                            // (5) データを書き込む
                            writer.write(input);

                        }, function (error) {
                            window.alert("読込失敗 :" + error.code + " - " + message);
                        });

                    }, function (error) {
                        window.alert("読込失敗 :" + error.code + " - " + message);
                    });
                },
                function(error){
                    window.alert("読込失敗 :" + error.code + " - " + message);
                }
            );
        };


        window.resolveLocalFileSystemURL(
            cordova.file.dataDirectory + "memo.txt",
            function (entry) {
                entry.file(function (file) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $scope.$apply(function () {
                            $scope.input = e.target.result;
                        })
                    };
                    //  テキストを読みこむ場合
                    reader.readAsText(file);
                });
            },
            function (error) {
                window.alert("読込失敗 :" + error.code + " - " + message);
            }
        );

    };

    var module = angular.module('cdv.file.write.controllers', []);
    module.controller('FileWriteController', ['$scope', FileWriteController]);
}());
