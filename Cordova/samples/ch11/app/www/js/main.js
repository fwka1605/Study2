(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.contact.controllers',
        'ui.router'
    ]);

    module.config(['$compileProvider', function ($compileProvider) {
        $compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|local|data|content|file):/);
    }]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('list', {
            url: '/list',
            controller: 'ContactListController',
            templateUrl: 'views/list.html'
        }).state('info',{
            url : '/info/{id}',
            controller : 'InfoContactController',
            templateUrl : 'views/info.html'
        }).state('add',{
            url : '/add',
            controller : 'AddContactController',
            templateUrl : 'views/add.html'
        }).state('pick',{
            url : '/pick',
            controller : 'PickContactController',
            templateUrl : 'views/pick.html'
        });

        $urlRouterProvider.otherwise("/list");
    });
}());
