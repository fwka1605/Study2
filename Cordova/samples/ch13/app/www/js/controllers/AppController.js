(function(){
    var module = angular.module('main.controllers',[]);
    function AppController($scope){
        $scope.ready = true;

        $scope.platform = device.platform;

    };
    module.controller('AppController',['$scope',AppController]);
}());