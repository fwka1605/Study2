<element ng-bind-template="{{var1}}と{{var2}}">
</element>
	
var1:プロパティを含む、バインドされる文字列
var2:プロパティを含む、バインドされる文字列
	
	
<div ng-bind="my.memo"></div>
<div ng-bind-template="{{my.memo}}"></div>

上記２つは同じ結果になる。
ng-bind属性がモデル（コントローラのプロパティ）をバインドするのに対して、
ng-bind-template属性はテンプレートをバインドします。
	
上記のような例であれば、ng-bind属性を利用したほうがシンプルなので、
通常は、ng-bind-template属性は複数のAngular式を組み合わせる用途で利用します。

例
	
<div ng-bind-template="{{my.name}}さんは{{my.age}}歳です。"></div>
