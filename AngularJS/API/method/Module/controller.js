controller(name,constructor)
	
〇戻り値
Moduleオブジェクト
※Moduleオブジェクトのメソッドのほとんどは
　戻り値として自分自身（Moduleオブジェクト）を
　返します。 この性質を利用してメソッドチェーンで呼び出せます。
	
〇引数
name	コントローラー名
constructor	コンストラクターの関数
	
〇例
	
angular.module('myApp',[])
		.controller('MyController', function($scope){
			$scope.msg="こんにちは、AngularJS!";
		});