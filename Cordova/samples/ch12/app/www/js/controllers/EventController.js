(function(){
    var module = angular.module('cdv.event.controllers',[]);

    var selectedItem = null;

    function EventController($scope){

    };

    /**
     * 一覧を取得
     * @param $scope
     * @constructor
     */
    function EventListController($scope,$state){

        var now = new Date();
        var startDate = new Date(now.getFullYear(),now.getMonth(),1);
        var endDate   = new Date(now.getFullYear(),now.getMonth() + 1,1);

        $scope.model = {
            startDate : startDate,
            endDate : endDate
        };

        // Androidのみ
        $scope.listEventsInRange = function(){

            if($scope.form.$invalid){
                alert("form error");
                return;
            }

            startDate = $scope.model.startDate;
            endDate = $scope.model.endDate;

            window.plugins.calendar.listEventsInRange(startDate, endDate, function (events) {
                $scope.$apply(function(){
                    // イベントオブジェクトが配列で取得できる
                    $scope.list = events;
                });
            }, function (error) {
                console.log(error);
            });
        };

        $scope.findEvent = function(){
            if($scope.form.$invalid){
                alert("form error");
                return;
            }

            startDate = $scope.model.startDate;
            endDate = $scope.model.endDate;

            //  サンプルを含むイベントの取得
            var title = "サンプル";

            window.plugins.calendar.findEvent(title,null,null,startDate, endDate, function (events) {
                $scope.$apply(function(){
                    // イベントオブジェクトが配列で取得できる
                    $scope.list = events;
                    console.log(events);
                });
            }, function (error) {
                console.log(error);
            });
        };

        $scope.findEventWithOptions = function(){
            if($scope.form.$invalid){
                alert("form error");
                return;
            }

            startDate = $scope.model.startDate;
            endDate = $scope.model.endDate;

            var options = window.plugins.calendar.getCalendarOptions();
            options.calendarName = "Codezine"; // iOSの場合のみ有効

            window.plugins.calendar.findEventWithOptions(null,null,null,startDate, endDate, options,function (events) {
                console.log(events);
                $scope.$apply(function(){
                    $scope.list = events;
                });
            }, function (error) {
                alert(error);
            });
        }

        $scope.selectItem = function(item){
            selectedItem = item;
            $state.go('event.item');
        }
    };

    /**
     * イベントの追加
     * @param $scope
     * @constructor
     */
    function AddEventController($scope){

        $scope.createEvent = function(){

            if($scope.form.$invalid){
               alert("form error");
               return;
            }

            /*
            window.plugins.calendar.createEvent(
                $scope.model.title,
                $scope.model.location,
                $scope.model.memo,
                $scope.model.startDate,
                $scope.model.endDate,
                function(message){
                    console.log("OK ",message);
                },
                function(message){
                    console.log("NG ",message);
                }
            );
            */

            var opts = window.plugins.calendar.getCalendarOptions();
            opts.calendarName = 'Codezine'; // iOSの場合
            opts.calendarId   = '11';       // Androidの場合

            window.plugins.calendar.createEventWithOptions(
                $scope.model.title,
                $scope.model.location,
                $scope.model.memo,
                $scope.model.startDate,
                $scope.model.endDate,
                opts,
                function(message){
                    alert("OK :" + message);
                },
                function(message){
                    alert("NG :" + message);
                }
            );
        };

        $scope.createEventInteractively = function(){
            if($scope.form.$invalid){
                alert("form error");
                return;
            }

            var opts = window.plugins.calendar.getCalendarOptions();

            window.plugins.calendar.createEventInteractivelyWithOptions(
                $scope.model.title,
                $scope.model.location,
                $scope.model.memo,
                $scope.model.startDate,
                $scope.model.endDate,
                opts,
                function(message){
                    console.log("OK ",message);
                },
                function(message){
                    console.log("NG ",message);
                }
            );
        }
    };


    function ItemEventController($scope,$state){

        if(!selectedItem){
            $state.go('event.list');
            return;
        }

        $scope.model = {
            id    : selectedItem.id,
            title : selectedItem.title,
            location : selectedItem.location,
            notes : selectedItem.message,
            startDate : parseDate(selectedItem.startDate),
            endDate  : parseDate(selectedItem.endDate)
        };

        /**
         *  削除
         */
        $scope.deleteEvent = function(){

            // iOSの場合
            if(device.platform == 'iOS') {
                window.plugins.calendar.deleteEventFromNamedCalendar(
                    $scope.model.title,
                    $scope.model.location,
                    $scope.model.notes,
                    $scope.model.startDate,
                    $scope.model.endDate,
                    selectedItem.calendar,
                    function (msg) {
                        alert("OK :" + msg);
                        $state.go('event.list');
                    }, function (msg) {
                        alert("ERROR: " + msg);
                    });
            }
            else {
                window.plugins.calendar.deleteEvent(
                    $scope.model.title,
                    $scope.model.location,
                    $scope.model.notes,
                    $scope.model.startDate,
                    $scope.model.endDate,
                    function (msg) {
                        alert("OK :" + msg);
                        $state.go('event.list');
                    }, function (msg) {
                        alert("ERROR: " + msg);
                    });
            }
        }
        /**
         *  変更 ( iOSのみ )
         */
        $scope.modifyEvent = function(){

            var opts = window.plugins.calendar.getCalendarOptions();
            //  IDを指定して、変更する対象を明確にする
            opts.id = selectedItem.id;
            opts.calendarName = selectedItem.calendar; // iOSのみ有効


            //  カレンダー変更（指定）する場合のみ指定
            var newOpts = window.plugins.calendar.getCalendarOptions();
            //newOpts.recurrence = 'weekly';
            //newOpts.recurrenceInterval = 2;

            var org = {
                title : selectedItem.title,
                location : selectedItem.location,
                notes : selectedItem.message,
                startDate : parseDate(selectedItem.startDate),
                endDate  : parseDate(selectedItem.endDate)
            };

            window.plugins.calendar.modifyEventWithOptions(
                org.title,
                org.location,
                org.notes,
                org.startDate,
                org.endDate,
                $scope.model.title,
                $scope.model.location,
                $scope.model.notes,
                $scope.model.startDate,
                $scope.model.endDate,
                opts,
                newOpts,
                function(msg){
                    alert("OK Modify: " + msg);
                },function(msg){
                    alert("ERR Modify: "+ msg);
                }
            );

        }

    }

    function parseDate(str) {
        var nums = str.match(/\d+/g);

        var year = parseInt(nums[0],10);
        var month = parseInt(nums[1],10) - 1;
        var day = parseInt(nums[2],10);

        var hour = parseInt(nums[3],10);
        var min = parseInt(nums[4],10);
        var sec = parseInt(nums[5],10);
        return new Date(year,month,day,hour,min,sec);
    }

    module.controller('EventController',['$scope',EventController]);
    module.controller('EventListController',['$scope','$state',EventListController]);
    module.controller('AddEventController',['$scope',AddEventController]);
    module.controller('ItemEventController',['$scope','$state',ItemEventController]);
}());
