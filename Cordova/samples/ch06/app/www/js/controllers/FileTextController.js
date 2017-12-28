(function () {

    function FileTextController($scope) {

        $scope.save = function () {
            var input = $scope.input;

            window.resolveLocalFileSystemURL(
                cordova.file.dataDirectory,
                function(dir){
                    dir.getFile("memo.txt", {create: true}, function (entry) {
                        entry.createWriter(function (writer) {
                            writer.write(input);

                            window.alert('OK');

                        }, function (error) {
                            window.alert("書込失敗 :" + error.code + " - " + message);
                        });

                    }, function (error) {
                        window.alert("書込失敗 :" + error.code + " - " + message);
                    });
                },
                function(error){
                    window.alert("書込失敗 :" + error.code + " - " + message);
                }
            );
        };

        $scope.append = function(){

            var input = $scope.input;

            window.resolveLocalFileSystemURL(
                cordova.file.dataDirectory,
                function(dir){
                    dir.getFile("memo.txt", {create: true}, function (entry) {
                        entry.createWriter(function (writer) {
                            writer.seek(writer.length);
                            writer.write(input);

                            window.alert('OK');

                        }, function (error) {
                            window.alert("書込失敗 :" + error.code + " - " + message);
                        });

                    }, function (error) {
                        window.alert("書込失敗 :" + error.code + " - " + message);
                    });
                },
                function(error){
                    window.alert("書込失敗 :" + error.code + " - " + message);
                }
            );
        };


        $scope.remove = function(){
            window.resolveLocalFileSystemURL(
                cordova.file.dataDirectory + "memo.txt",
                function(entry){
                    entry.remove(function(){
                        window.alert("Remove OK");
                    },function(){
                        window.alert("Remove Error");
                    });
                },
                function(error){
                    window.alert("読込失敗 :" + error.code + " - " + message);
                }
            );
        };

        $scope.load = function() {

            window.resolveLocalFileSystemURL(
                cordova.file.dataDirectory + "memo.txt",
                function(entry) {
                    entry.file(function(file) {
                        var reader = new FileReader();
                        reader.onload = function(e) {
                            $scope.$apply(function() {
                                $scope.input = e.target.result;
                                console.log($scope.input);

                            })
                        };
                        //  テキストを読みこむ場合
                        reader.readAsText(file);
                    });
                },
                function(error) {
                    window.alert("読込失敗 :" + error.code + " - " + message);
                }
            );
        };


        //$scope.load();
    };

    var module = angular.module('cdv.file.text.controllers', []);
    module.controller('FileTextController', ['$scope', FileTextController]);
}());
