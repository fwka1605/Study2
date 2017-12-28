(function(){
    var module = angular.module('main.controllers',[]);
    function AppController($scope){
        $scope.ready = true;


        resolveLocalFileSystemURL('cdvfile://localhost/cache/', function(entry) {
            console.log(entry);
        });
        resolveLocalFileSystemURL('cdvfile://localhost/documents/', function(entry) {
            console.log(entry);
        });
        resolveLocalFileSystemURL('cdvfile://localhost/sdcard/', function(entry) {
            console.log(entry);
        });
    };
    module.controller('AppController',['$scope',AppController]);
}());
