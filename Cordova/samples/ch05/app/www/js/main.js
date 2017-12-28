(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.file.read.controllers',
        'cdv.file.write.controllers',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('file_props',{
            url : '/file_props',
            templateUrl : 'views/file_props.html',
            controller : 'FilePropsController'
        }).state('dir_read',{
            url : '/dir_read',
            templateUrl : 'views/dir_read.html',
            controller : 'DirReadController'
        }).state('file_read', {
            url: '/file_read',
            templateUrl: 'views/file_read.html',
            controller: 'FileReadController'
        });

        $urlRouterProvider.otherwise("/file_props");
    });
}());
