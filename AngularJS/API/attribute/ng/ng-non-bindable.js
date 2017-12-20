<element ng-non-bindable>{{var}}
</element>
	
var:プロパティを含む、バインドさせない文字列

バインドは{{}}でも実施することができる。 ただし、{{}}を評価しないで
表示したい場合がある。 この場合はng-non-bindable属性を使用する。

例
	
<body ng-controller="MyController as my">
<label for="name">名前：</label>
<input id="name" name="name" type="text" ng-model="my.myName" />
<div ng-non-bindable>{{"こんにちは、" + my.myName + "さん！"}}</div>
</body>