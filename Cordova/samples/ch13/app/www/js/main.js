(function(){
    var module = angular.module('main',[
        'main.controllers',
        'cdv.cal.controllers',
        'cdv.event.controllers',
        'cdv.ui.controllers',
        'ui.router'
    ]);

    module.config(['$compileProvider', function ($compileProvider) {
        $compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|local|data|content|file):/);
    }]);

    module.config(function($stateProvider,$urlRouterProvider){

        $stateProvider.state('ui',{
            url : '/ui',
            controller : 'CalendarUIController',
            templateUrl: 'views/ui.html'
        });

        $stateProvider.state('cal',{
            url : '/cal',
            controller : 'CalendarController',
            templateUrl: 'views/calendars.html'
        }).state('cal.list',{
            url: '/list',
            controller: 'CalListController',
            templateUrl: 'views/calendar/list.html'
        }).state('cal.add',{
            url : '/add',
            controller: 'CalAddController',
            templateUrl: 'views/calendar/add.html'
        });

        $stateProvider.state('event',{
            url : '/event',
            controller : 'EventController',
            templateUrl: 'views/event.html'
        }).state('event.list',{
            url: '/list',
            controller: 'EventListController',
            templateUrl: 'views/event/list.html'
        }).state('event.add',{
            url : '/add',
            controller : 'AddEventController',
            templateUrl: 'views/event/add.html'
        }).state('event.item',{
            url : '/item',
            controller : 'ItemEventController',
            templateUrl: 'views/event/item.html'
        });

        $urlRouterProvider.otherwise("/cal/list");
    });
}());
