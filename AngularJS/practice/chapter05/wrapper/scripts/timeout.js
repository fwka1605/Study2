angular.module('myApp', [])
  .controller('MyController', ['$scope', '$timeout',  function($scope, $timeout) {
    var timer = $timeout(function() {
      $scope.greeting = 'ようこそ、世界！';
    }, 3000);

    $scope.onclick = function() {
      $timeout.cancel(timer);
    };
  }]);
