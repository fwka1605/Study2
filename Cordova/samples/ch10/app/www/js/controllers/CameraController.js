(function(){
    var module = angular.module('cdv.camera.controllers',[]);
    function CameraController($scope){

        $scope.message = "";

        // オプション
        var cameraOptions = {
            cameraDirection : Camera.Direction.BACK,          // 起動後に選べる
            destinationType : Camera.DestinationType.DATA_URL,
            encodingType : Camera.EncodingType.JPEG,
            targetWidth : 360,
            targetHeight: 480,
        };

        $scope.camera = function(){
            navigator.camera.getPicture(function(result){
                $scope.$apply(function(){
                    var src = "data:image/jpeg;base64," + result;
                    $('#image').attr('src',src);
                });

            },function(message){
                $scope.$apply(function(){
                    $scope.message = "error :" + message;
                });

            },cameraOptions);
        };


        $scope.sourceType = String(Camera.PictureSourceType.PHOTOLIBRARY);
        $scope.mediaType = String(Camera.MediaType.ALLMEDIA);
        $scope.encodingType = String(Camera.EncodingType.JPEG);
        $scope.cameraDirection = String(Camera.Direction.BACK);

        $scope.select = function(){

            $scope.message = null;

            navigator.camera.getPicture(function(result){
                $scope.$apply(function(){

                    $scope.path = result;

                    // Androidの場合でかつcontent://から始まる場合
                    if (result.indexOf('content://') != -1) {
                        window.FilePath.resolveNativePath(result, function(path){
                            $('#image').attr('src',path);
                        },function(err){

                        });
                    }
                    else{
                        $('#image').attr('src',result);
                    }
                });

            },function(message){
                $scope.$apply(function(){
                    $scope.message = "error:" + message;
                });

            },{
                destinationType: Camera.DestinationType.FILE_URI,
                sourceType : Number($scope.sourceType),
                mediaType  : Number($scope.mediaType),
                encodingType : Number($scope.encodingType),
                cameraDirection : Number($scope.cameraDirection)
            });
        }

        $scope.$on('$destroy',function(){
            navigator.camera.cleanup(function(){
                console.log("ok : cleanup");
            },function(message){
                console.log("ng : cleanup - " + message);
            });
        });
    };
    module.controller('CameraController',['$scope',CameraController]);
}());
