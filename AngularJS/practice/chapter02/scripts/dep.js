// myApp.mainからmyApp.subを利用する。
angular.module('myApp.main', ['myApp.sub'])
	.controller('MainController', function($scope){
	    $scope.msg='MainControllerです';
	});

// myApp.subからngMessagesとngCookiesを利用する。
angular.module('myApp.sub', ['ngMessages','ngCookies'])
	.controller('SubController', function($scope){
	    $scope.msg='SubControllerです';
	});

