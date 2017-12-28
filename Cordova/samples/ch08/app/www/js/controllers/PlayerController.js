(function () {
    var module = angular.module('cdv.media.play', []);

    function PlayerController($scope) {

        var mediaOk = false;
        var timer;
        var vol = 0.5;

        $scope.duration = 0;
        this.mediaSuccess = function () {
            console.log("media success");
        };
        this.mediaError = function (e) {
            window.alert("Error :" +  e.code);
        };
        this.mediaStatus = function (status) {
            if(status != Media.MEDIA_NONE){
                mediaOk = true;
                var duration = media.getDuration();
                if(duration > 0){
                    $scope.$apply(function(){
                        $scope.duration = duration;
                    })
                }
            }
            if(status == Media.MEDIA_RUNNING){
                timer = setInterval(function() {
                    if($scope.duration <= 0) {
                        var duration = media.getDuration();
                        if(duration > 0) {
                            $scope.$apply(function() {
                                $scope.duration = duration;
                            })
                        }
                    }

                    media.getCurrentPosition(function (sec) {
                        if(sec > 0) {
                            $scope.$apply(function() {
                                $scope.current = sec;
                            });
                        }
                    });
                },200);
            }
            else if(status == Media.MEDIA_STOPPED){
                if(timer){
                    clearInterval(timer);
                    timer = null;
                    $scope.$apply(function() {
                        $scope.current = 0;
                    });
                }
            }
        };

        var src;
        if(device.platform == 'iOS'){
            src = "res/music.mp3";
        }
        else {
            src = cordova.file.applicationDirectory + "www/res/music.mp3";;
        }
        var media = new Media(src, this.mediaSuccess, this.mediaError, this.mediaStatus);
        $scope.current = 0;

        media.setVolume(vol);
        //
        $scope.play = function () {
            media.play();
        };
        $scope.pause = function () {
            media.pause();
        };
        $scope.stop = function () {
            media.stop();
        };

        $scope.volUp = function(){
            vol += 0.1;
            if(vol > 1){
                vol = 1;
            }
            media.setVolume(vol);
        };
        $scope.volDown = function(){
            vol -= 0.1;
            if(vol < 0){
                vol = 0;
            }
            media.setVolume(vol);
        };

        $scope.skip = function(){
            var millsec = ($scope.current * 1000) + (10 * 1000);
            media.seekTo(millsec);
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
    module.controller('PlayerController', ['$scope', PlayerController]);
}());