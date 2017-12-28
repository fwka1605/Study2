(function(){
    var module = angular.module('main.controllers',[]);
    function AppController($scope){
        $scope.ready = true;


        var source = navigator.camera.PictureSourceType;
        var type   = navigator.camera.DestinationType;

        console.log("current source , type",source,type);
    };
    module.controller('AppController',['$scope',AppController]);
}());