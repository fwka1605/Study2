angular.module('myApp', [])
	.controller('MyController', ['$scope','$timeout', function($scope,$timeout){
		$timeout(function(){
			$scope.url = 'http://gihyo.jp/dp';
		},4000);
	}]);