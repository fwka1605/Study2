(function(){
    var module = angular.module('main.controllers',[]);
    function AppController($scope){
        console.log("app started",this);
        $scope.ready = true;
    };
    module.controller('AppController',['$scope',AppController]);
}());
