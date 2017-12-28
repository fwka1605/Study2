(function(){
    var module = angular.module('cdv.device',[]);

    function DeviceController($scope){
        console.log("device platform is " + device.platform);
        $scope.device = device;
    };
    module.controller('DeviceController',['$scope',DeviceController]);
}());
