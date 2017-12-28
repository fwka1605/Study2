(function () {
    var module = angular.module('cdv.media.record', []);

    function MediaRecordController($scope) {

        var mediaOk = false;
        var isRec = false;
        var timer;

        $scope.duration = 0;
        this.mediaSuccess = function () {
            console.log("media success");
        };

        this.mediaError = function (e) {
            window.alert("Error :" +  e.code);
            console.log(e);
        };
        this.mediaStatus = function (status) {
            console.log("record status updated " + status);
            if(status != Media.MEDIA_NONE){
                mediaOk = true;
            }
            if(status == Media.MEDIA_RUNNING){
                if(isRec) {
                    timer = setInterval(function () {
                        media.getCurrentAmplitude(function (sec) {
                            $scope.$apply(function () {
                                $scope.current = sec;
                            });
                        });
                    }, 200);
                }
            }
            else if(status == Media.MEDIA_STOPPED){

            }
        };
        var src;
        if(device.platform == 'iOS'){
            src = "record.wav";
        }
        else {
            // aacもAndroidのバージョンによって使えるようです
            src = "record.amr";
        }
        var media = new Media(src, this.mediaSuccess, this.mediaError, this.mediaStatus);
        $scope.current = 0;

        $scope.play = function () {
            media.play();
        };

        $scope.start = function () {
            isRec = true;
            media.startRecord();
        };
        $scope.pause = function () {
            media.pause();
        };
        $scope.stop = function () {
            media.stopRecord();
        };

        $scope.$on('$destroy', function () {
            if(timer){
                clearInterval(timer);
                timer = null;
            }
            if (mediaOk) {
                media.release();
            }
        });

    };
    module.controller('MediaRecordController', ['$scope', MediaRecordController]);
}());