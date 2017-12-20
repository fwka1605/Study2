config([requires ]);

〇戻り値
Moduleオブジェクト
	
〇引数
name:モジュール名
requires:設定するプロバイダー

〇サンプル
angular.module('myApp', [])
  .config(['$sceDelegateProvider',function($sceDelegateProvider){
  	$sceDelegateProvider.resourceUrlWhitelist([
  		'self',
  		'http://www.wings.msn.to/**'
  	]);	
  }])
  .controller('MyController', ['$scope', function($scope) {
    $scope.url = 'http://www.wings.msn.to/';
  }]);
  
$sceDelegateProviderに限らず、全てのプロバイダーは、controllerの配下ではなく、
configメソッドは以下で設定しなければならない点で注意してください。
	
configメソッドは、サービスのインスタンスが生成される前に呼び出されるメソッドに
なります。　そのため、プロバイダーは、その性質上、サービスが呼び出される前に
準備を終えていなければなりません。
	
		