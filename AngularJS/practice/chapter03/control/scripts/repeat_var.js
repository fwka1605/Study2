angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.years = ['子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥'];
  }]);
