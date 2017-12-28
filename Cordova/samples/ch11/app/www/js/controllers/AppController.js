(function(){
    var module = angular.module('main.controllers',[]);
    function AppController($scope){
        $scope.ready = true;
    };
    module.controller('AppController',['$scope',AppController]);
}());