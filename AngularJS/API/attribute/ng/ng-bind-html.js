<element ng-bind-html="var">
</element>
	
var:プロパティを含む、バインドされる文字列

ng-bindで文字列をバインドする際に、文字列内にHTMLのタグなどが含まれている
場合はエスケープ処理され、単なる文字列としてページに表示される。
意図しないHTMLをページに混入させないためにもこの挙動は正常であり、正しい。

しかし、動的に生成したHTML文字列をページに反映させたいケースもある。
そのような場合に利用するのが、ng-bint-html属性になる。	

注意
ng-bind-html属性は、内部的にngSanitizeモジュールに依存している。 そのため
ng-bin-html属性を利用するには、ngSanitizeモジュールを有効化する必要がある。
	
angular.module('myApp',['ngSanitize'])
	.controller('MyController',[function(){	
}]);

またngSanitizeには、消毒・無害化などの意味があり、
文字列から、有害の可能性がある特定のタグ（<script>,<button>,
onmouseover属性など）が除去されます。

例
	
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8" />
<title>AngularJS</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular-sanitize.min.js"></script>
<script src="scripts/bind_html.js"></script>
</head>
<body ng-controller="MyController as my">
  <div ng-bind-html="my.memo"></div>
</body>
</html>
	
angular.module('myApp', [ 'ngSanitize' ])
  .controller('MyController', [ function() {
    this.memo = '<p onmouseover="alert(\'OK!\')">ようこそ</p>'
                  + '<a href="http://www.wings.msn.to">WINGSへ</a>'
                  + '<script>var x = 1;</script>'
                  + '<button>応募</button>';
  }]);

ngSanitizeによる除去を実施せず、HTML要素等をそのまま表示したい場合は、
文字列が安全な内容であることを示すために、信頼済みマークを付与する必要が
ある。

例
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8" />
<title>AngularJS</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular.min.js"></script>
<script src="scripts/bind_html_trust.js"></script>
</head>
<body ng-controller="MyController as my">
  <div ng-bind-html="my.memo"></div>
</body>
</html>
		
angular.module('myApp', [  ])
  .controller('MyController', [ '$sce',function($sce) {
    this.memo = '<p onmouseover="alert(\'OK!\')">ようこそ</p>'
                  + '<a href="http://www.wings.msn.to">WINGSへ</a>'
                  + '<script>var x = 1;</script>'
                  + '<button>応募</button>';
    this.memo=$sce.trustAsHtml(this.memo);
  }]);

ngSanitizeが不要のため、ngSanitizeモジュールへの依存関係を除去する。
さらに文字列に信頼済みマークを付与するためには、SCE(Strlct Contextual Escaping)
の機能を利用する必要がある。	
そのため、$sceオブジェクトへの参照をDIし、そのオブジェクトのtrustAsHtmlメソッドを
実行する必要がある。
	
注意：trustAsHtml
trustAsHtmlメソッドにより、文字列に信頼済みのマークを付与することができるが、
文字列の中身を保証するものではない。 文字列の中身の信頼を保証するのは、
あくまでも開発者自身の責任になる。