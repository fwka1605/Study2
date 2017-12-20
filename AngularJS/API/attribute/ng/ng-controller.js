<element ng-controller="MyController"></element>

MyController：使用するコントローラ
	
ページで使用するコントローラを指定する。
	
通常は、bodyタブで指定するが、1ページで複数のコントローラを
指定する場合は、divなどの要素で指定する。
	
注意：
ng-controller="MyController"で指定されたコントローラは、その要素の
配下でのみ有効になる。
	
例
<div ng-controller="MyController" ng-init="name='権兵衛'">
  <label for="name">名前：</label>
  <input id="name" type="text" ng-model="name" />
</div>
<hr />
<div ng-controller="MyController">
  こんにちは、{{name}}さん！
</div>

同一コントローラを指定しているで、スコープオブジェクトの引き渡しがされると思われるかも
しれませんが、上記の例では、{{name}}が表示されません。

これは、コントローラが、ng-controller属性の単位でインスタン化されるためです。 そのため、
ng-controller="MyController"で作成したインスタンスは、最初と２番目では独立したインスタンスに
なります。
