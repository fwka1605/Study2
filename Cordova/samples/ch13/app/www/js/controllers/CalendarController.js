(function(){
    var module = angular.module('cdv.cal.controllers',[]);

    function CalendarController($scope){

    };

    function CalListController($scope){

        var loadCal = function(){
            window.plugins.calendar.listCalendars(function(list){
                $scope.$apply(function(){
                    $scope.list = list;
                    //console.log(list);
                });

            },function(){
                alert("NG:LIST CAL",arguments);
            });
        };

        var deleteItem = function(){
            if($scope.target){
                var name = $scope.target.name;
                // カレンダーの削除
                window.plugins.calendar.deleteCalendar(name,function(){
                    //  削除成功
                    $('#cal_delete').modal('hide');
                    loadCal();
                },function(){
                    $scope.$apply(function(msg){
                        $scope.message = msg;
                    });
                });
            }
        };

        var showDialog = function(item){
            $scope.target = item;
            $('#cal_delete').modal('show');
        };

        $scope.refresh = loadCal;
        $scope.deleteItem = deleteItem;
        $scope.showDialog = showDialog;

        loadCal();
    };

    /**
     * カレンダーの追加
     * @param $scope
     * @constructor
     */
    function CalAddController($scope){

        $scope.message = null;

        $scope.add = function(){

            if($scope.form.$invalid){
                $scope.$apply(function(){
                    $scope.message = "INPUT ERROR";
                });
                return;
            }

            var opts = window.plugins.calendar.getCreateCalendarOptions();
            opts.calendarName = $scope.model.title;
            opts.calendarColor = "#FF0000";

            window.plugins.calendar.createCalendar(opts,function(msg){
                $scope.$apply(function(){
                    $scope.message = "OK:" + msg;
                });

            },function(msg){
                $scope.$apply(function(){
                    $scope.message = "ERROR :" + msg;
                });
            });

        }
    }

    module.controller('CalendarController',['$scope',CalendarController]);
    module.controller('CalListController',['$scope',CalListController]);
    module.controller('CalAddController',['$scope',CalAddController]);
}());
