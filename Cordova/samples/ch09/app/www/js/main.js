(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.mediacapture',
        'cdv.media.record',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('media',{
            url : '/media',
            controller : 'MediaRecordController',
            templateUrl : 'views/record.html'
        });

        $stateProvider.state('capture',{
            url : '/capture',
            controller : 'MediaCaptureController',
            templateUrl : 'views/capture.html'
        });

        $urlRouterProvider.otherwise("/media");
    });
}());
