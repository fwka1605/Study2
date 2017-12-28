(function () {

    function FileImageController($scope) {

        $scope.filename = null;

        $scope.save = function () {

            var file_element = $('#file')[0];
            var file = file_element.files[0];
            if(file) {

                $scope.filename = file.name;

                var reader = new FileReader();
                reader.onloadend = function(evt){

                    window.resolveLocalFileSystemURL(
                        "cdvfile://localhost/cache/",
                        function(dir) {
                            dir.getFile($scope.filename, {create: true}, function(entry) {
                                entry.createWriter(function(writer) {
                                    
                                    writer.write(reader.result);

                                    window.alert('OK :' + $scope.filename);

                                }, function(error) {
                                    window.alert("書込失敗 :" + error.code + " - " + message);
                                });

                            }, function(error) {
                                window.alert("書込失敗 :" + error.code + " - " + message);
                            });
                        },
                        function(error) {
                            window.alert("書込失敗 :" + error.code + " - " + message);
                        }
                    );
                };
                reader.readAsArrayBuffer(file);
            }
        };
        $scope.load = function () {
            if($scope.filename){
                // <img src="" /> を出力
                $scope.img_path = "cdvfile://localhost/cache/" + $scope.filename;
                //$('#img_path').attr('src',"cdvfile://localhost/cache/" + filename);
            }
        };
    };



    var module = angular.module('cdv.file.image.controllers', []);
    module.controller('FileImageController', ['$scope', FileImageController]);
}());
