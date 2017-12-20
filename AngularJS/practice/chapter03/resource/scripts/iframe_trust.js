angular.module('myApp', [])
  .controller('MyController', ['$scope','$sce', function($scope,$sce) {
    $scope.url = $sce.trustAs($sce.RESOURCE_URL,'http://www.wings.msn.to/');
  }]);