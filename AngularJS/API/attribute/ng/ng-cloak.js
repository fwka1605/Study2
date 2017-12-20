<element ng-cloak>{{var}}
</element>
	
var:プロパティを含む、バインドされる文字列


バインドは{{}}でも実施することができる。 ただし、
{{}}には問題もある。
AngularJSはJavaScriptのため、クライアント側にダウンロードされてから
実行されることになる。 そのため、{{}}を使用すると、瞬間的ではあるが
クライアントに表示される可能性がある。 そのために、ng-cloakを使用する。

ng-cloak属性は、AngularJSが内部的に生成する以下のスタイルシートによって、
現在の要素を非表示にします。
	
ng-cloak {display:none !important:}

AngularJSは、初期化のタイミングでng-cloak属性を見つけると、これを破棄し、
要素を表示状態にします。 これによって、初期化前のAngular式を含んだ要素が
そのまま表示されてしまうのを防げるわけです。

使用上の注意点：
ng-cloak属性では、AngularJSが生成するスタイルシートを利用するという性質上、
AngularJSをページの先頭でインポートする必要があります。
	
ng-cloak属性を<body>要素に対して付与することもできるが、その場合は
AngularJSの初期化が完了するまで全ての要素が非表示になります。
そのため、ページ表示までの時間がかかってしまいます。そのため、ng-cloak属性は、
面倒でもできるだけ個別の要素に対して付与すべきです。

例
	
<body ng-controller="MyController as my">
<label for="name">名前：</label>
<input id="name" name="name" type="text" ng-model="my.myName" />
<div ng-cloak>{{"こんにちは、" + my.myName + "さん！"}}</div>
</body>
