(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.click.sound',
        'cdv.media.play',
        'ui.router'
    ]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('click',{
            url : '/click',
            controller : 'ClickSoundPlayController',
            templateUrl : 'views/click.html'
        });
        $stateProvider.state('player',{
            url : '/player',
            controller : 'PlayerController',
            templateUrl : 'views/player.html'
        });
        $urlRouterProvider.otherwise("/click");
    });
}());
