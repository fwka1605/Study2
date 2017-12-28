(function(){
    var module = angular.module('cdv.network',[]);

    function NetworkController($scope){
        console.log("start network", navigator,Connection);
        $scope.type = navigator.connection.type;

        if(navigator.connection.type == Connection.NONE ||
            navigator.connection.type == Connection.UNKNOWN){
            $scope.offline = true;
        }
        else{
            $scope.online = true;
        }

        this.onlineListener = function(){
            console.log("online");
            $scope.$apply(function(){
                $scope.type = navigator.connection.type;
                $scope.online = true;
                $scope.offline = false;
            });
        };
        this.offlineListener = function(){
            console.log("offline");
            $scope.$apply(function(){
                $scope.type = navigator.connection.type;
                $scope.offline = true;
                $scope.online = false;
            });
        };
        var that = this;
        $scope.$on('$destroy',function(){
            document.removeEventListener('online',that.onlineListener);
            document.removeEventListener('offline',that.offlineListener);
        });

        document.addEventListener('online',this.onlineListener,false);
        document.addEventListener('offline',this.offlineListener,false);
    };
    module.controller('NetworkController',['$scope',NetworkController]);
}());
