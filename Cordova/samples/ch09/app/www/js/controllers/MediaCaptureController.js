(function(){
    var module = angular.module('cdv.mediacapture',[]);
    function MediaCaptureController($scope){

        function captureSuccess(mediaFiles){

            var size = mediaFiles.length;
            for(var i = 0; i < size; i++){
                var file = mediaFiles[i];
                console.log(file.name);
            }

            $scope.$apply(function(){
                $scope.files = mediaFiles;
            });
        };

        function captureError(error){
            if(error.code == CaptureError.CAPTURE_NO_MEDIA_FILES){
                window.alert("ユーザによりキャンセルされました");
            }
            else {
                window.alert('Error code: ' + error.code + " - " + error.message);
            }
        };

        $scope.captureAudio = function(){
            navigator.device.capture.captureAudio(captureSuccess, captureError, {limit:1});
        };

        $scope.captureImage = function(){
            navigator.device.capture.captureImage(captureSuccess, captureError, {limit:2});
        }

        $scope.captureVideo = function(){
            navigator.device.capture.captureVideo(captureSuccess, captureError, {limit:1});
        };
    };
    console.log("module....");
    module.controller('MediaCaptureController',['$scope',MediaCaptureController]);
}());