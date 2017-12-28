(function(){
    var module = angular.module('cdv.click.sound',[]);
    function ClickSoundPlayController($scope){

        var src;
        if(device.platform == 'iOS'){
            src = "res/click_01.mp3";
        }
        else {
            src = cordova.file.applicationDirectory + "www/res/click_01.mp3";
        }
        var media = new Media(src);

        $scope.clickAndPlay = function(){
            media.play();
        };

        $scope.$on('$destroy',function(){
            media.release();
        });

    };
    module.controller('ClickSoundPlayController',['$scope',ClickSoundPlayController]);
}());