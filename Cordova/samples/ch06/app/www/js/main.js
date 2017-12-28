(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.file.text.controllers',
        'cdv.file.image.controllers',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('text',{
            url : '/text',
            templateUrl : 'views/file_text.html',
            controller : 'FileTextController'
        }).state('image',{
            url : '/image',
            templateUrl : 'views/file_image.html',
            controller : 'FileImageController'
        });

        $urlRouterProvider.otherwise("/text");
    });

    module.config(function($compileProvider) {
        $compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|ftp|mailto|cdvfile):/);
    });
}());
