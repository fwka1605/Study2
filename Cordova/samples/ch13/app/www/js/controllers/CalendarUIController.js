(function(){
    var module = angular.module('cdv.ui.controllers',[]);

    function CalendarUIController($scope){

        $scope.open = function(){
            window.plugins.calendar.openCalendar();
        };

        $scope.openDate = function(){

            window.plugins.calendar.openCalendar($scope.date,
                function(msg){
                    console.log("OK:" + msg);
                },function(msg){
                    console.log("NG:" + msg);
                }
            );
        }
    };
    module.controller('CalendarUIController',['$scope',CalendarUIController]);
}());
