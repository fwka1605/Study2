<a ng-href="{{url}}">リンク先</a>
	
url:リンク先のURL

<a href="{{url}}">という形でリンク先を動的に生成しても
問題がないと感じるかもしれない。
	
しかし、AngularJSでJavaScriptのフレームワークであり、クライアントに
ダウンロードされてから実行される。 そのため、{{url}}が評価されるまでは
このリンクは有効にならない。 有効前にユーザがリンクをクリックしても
正しく遷移されないことになる。
	
これに対応する方法の1つとして、ng-hrefがある。
	
<a ng-href="{{url}}">リンク先</a>では、ng-hrefはHTMLのhrefではないため、
JavaScriptの処理前、つまり有効になる前はリンクとして動作しないため、
リンク先の箇所は単なる文字として表示するだけになる。 JavaScriptの動作が
完了するとリンクが有効になり、リンク先にリンクが張られることになる。

例
	
<!DOCTYPE html>

<html ng-app="myApp">

<head>
  <meta charset="UTF-8" />
  <title>AngularJS</title>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.min.js"></script>
  <script type="text/javascript" src="./scripts/href.js"></script>
</head>

<body ng-controller="MyController">

<a ng-href="{{url}}">出版社の電子書籍サイトへ</a>
	
</body>

</html>