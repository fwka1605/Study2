<element ng-jq="ブール値"></element>
	
AngularJSアプリで、jqLite/jQueryいずれを利用できるかを特定
することができる。	

①jqLiteの利用を強制する
		
例：<html ng-app ng-jq>

これで、angular.elementメソッドの戻り値をjqLiteオブジェクトで
固定できます。 これはjQueryプラグインなどを利用している関係で
jQueryはインポートしているが、アプリ本体ではjqLiteを利用したい
場合などに利用します。
	
②jQueryのバージョンを固定にする。

１つのページで複数のjQueryを利用したい場合があります。
特定のプラグインでは、jQuery 1.xが必要だが、AngularJSアプリでは
jQuery 2.xが必要になります。	
	
例：
<!DOCTYPE html>
<html ng-app ng-jq="newJq">
<head>
～
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
var newJq = jQuery.noConflict();
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular.min.js"></script>
</head>
<body>
～
</body>
</html>
	
ここでは、ng-jq属性にjQueryの別名を指定しています。 これで
AngularJSとして利用するjQueryのバージョンを固定することが
できます。
	
参考：jQuery/jqLiteのAngular JS拡張
	
１．イベント系
	
	$destroy	要素ノード破壊の際に発生

２．メソッド
	controller([name])	現在の要素、もしくはその親要素のコントローラを
						取得。
						引数nameはディレクティブ名を指定。
	injector()	現在の要素、もしくはその親要素の$injectorを取得
	
	scope()	現在の要素、もしくはその親要素のスコープオブジェクトを取得
	
	isolateScope()	現在のよそに関連づいた分離スコープを取得
		
	inheritedData()	dataメソッドと同様。ただし、見つかるまで上位要素を
					検索。
		
		
例
	
<body>
<button id="btn">表示</button>
<div id="main">現在時刻：{{msg}}</div>
<script>
angular.element(document.getElementById('btn')).on('click', function() {
  var $scope = angular.element(document.getElementById('main')).scope();
  $scope.$apply(function() {
    $scope.msg = new Date().toLocaleString();
  });
});
</script>
</body>
	
angular.elementで取得した要素のscopeを取得している。



