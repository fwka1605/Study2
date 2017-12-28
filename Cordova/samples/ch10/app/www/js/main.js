(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.camera.controllers',
        'cdv.picker.controllers',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('camera',{
            url : '/camera',
            controller : 'CameraController',
            templateUrl : 'views/camera.html'
        }).state('picker',{
            url : '/picker',
            controller : 'ImagePickerController',
            templateUrl : 'views/picker.html'
        });
        $urlRouterProvider.otherwise("/camera");
    });
}());
