<element ng-bind="var">
</element>
	
var:プロパティを含む、バインドされる文字列


バインドは{{}}でも実施することができる。 ただし、
{{}}には問題もある。
AngularJSはJavaScriptのため、クライアント側にダウンロードされてから
実行されることになる。 そのため、{{}}を使用すると、瞬間的ではあるが
クライアントに表示される可能性がある。 そのために、ng-bindを使用する。

ng-bindはHTMLの属性として定義されるため、実行前であろうがクライアント側に
表示されること、つまり、ユーザの目に触れることがない。 そのため、通常は
ng-bindを使用するべきである。
	
ng-bindで文字列をバインドする際に、文字列内にHTMLのタグなどが含まれている
場合はエスケープ処理され、単なる文字列としてページに表示される。
意図しないHTMLをページに混入させないためにもこの挙動は正常であり、正しい。

しかし、動的に生成したHTML文字列をページに反映させたいケースもある。
そのような場合に利用するのが、ng-bint-html属性になる。	

例
	
<body ng-controller="MyController as my">
<label for="name">名前：</label>
<input id="name" name="name" type="text" ng-model="my.myName" />
<div ng-bind="'a' + my.myName"></div>
</body>	