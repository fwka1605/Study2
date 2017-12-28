(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.file.transfer.controllers',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('upload',{
            url : '/upload',
            templateUrl : 'views/upload.html',
            controller : 'FileUploadController'
        }).state('download',{
            url : '/download',
            templateUrl : 'views/download.html',
            controller : 'FileDownloadController'
        });

        $urlRouterProvider.otherwise("/download");

    });

    module.config(function($compileProvider) {
        $compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|ftp|mailto|cdvfile):/);
    });
}());
