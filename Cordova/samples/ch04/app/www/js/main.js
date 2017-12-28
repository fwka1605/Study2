(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.device',
        'cdv.network',
        'cdv.dialog',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){
        $stateProvider.state('device',{
            url : '/device',
            templateUrl : 'views/device.html',
            controller : 'DeviceController'
        }).state('network',{
            url : '/network',
            templateUrl : 'views/network.html',
            controller : 'NetworkController'
        }).state('dialog',{
            url : '/dialog',
            templateUrl : 'views/dialog.html',
            controller : 'DialogController'
        });
        $urlRouterProvider.otherwise("/device");
    });
}());
