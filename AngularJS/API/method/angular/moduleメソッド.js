module(name [,requires [,config] ]);

〇戻り値
Moduleオブジェクト
	
〇引数
name:モジュール名
requires:依存するモジュール（配列）
		任意だが新しくモジュールを作成する場合は、必ず指定する。
		指定すべき値がない場合のも空の配列を指定する。
		省略した場合は既存のモジュールを取得する。
config:構成の定義

〇サンプル
新規にモジュールを作成する。
angular.module('myApp',[])
		.controller('MyController', function($scope){
			$scope.msg="こんにちは、AngularJS!";
		});
		
既存モジュールを取得
angular.module('myApp',[]);

angular.module('myApp')
		.controller('MyController', function($scope){
			$scope.msg="こんにちは、AngularJS!";
		});

～当然同じファイル内で上記のように書く必要はないが、アプリの規模が
	大きくなると、モジュール宣言と、その他のコンポーネントの宣言を
	異なるファイルで管理したいというケースも出てきます。そのような場合に
	使用します。
	