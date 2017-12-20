<element ng-model="var">
</element>
	
element:input/textarea/selectなどのフォーム要素
var:モデル（スコーププロパティ名）

注意：
ng-model属性によってフォーム要素とモデルとを紐づけた場合、
フォーム要素側で設定したデフォルト値は無視されます。
初期値を設定するには、コントローラ内で$scopeオブジェクトの
該当プロパティの初期値を設定する必要があります。
また、この初期値はモデルだけでなくビューにも反映されます。

	
例
	
  <lable for="name">名前</lable>
  <input id="name" name="name" type="text" ng-model="myName" />

  <div>こんにちは{{myName}}さん！</div>
   
〇ワンタイムバインディング（One-time Binding)

Angularでは、デフォルトでは双方向バインディングが有効になっています。
双方向バインディングを実現するためには、モデル（$scopeオブジェクト）の
値の変化を常に監視、値が変更されれば即時にビューに反映する必要があります。
この監視/反映の反復は、ページが複雑になり、バインディングする変数が
増えるほど、そのオーバーヘッドも大きくなり、パフォーマンスを低下させる
原因にもなります。

そのためAngularJSでは、One-time-Binding（ワンタイムバインディング）と
呼ばれる機能も提供しています。

One-time Bindingとは、名前の通り、式の値がundefinedの間だけ監視を行い、
一度値が設定されたら監視を打ち切る仕組みになります。
これによって、初期化時にのみバインドすることができ、延々と監視/反映の
繰り返しを行うことを回避することができます。
	
  <lable for="name">名前</lable>
  <input id="name" name="name" type="text" ng-model="myName" />

  <div>こんにちは{{myName}}さん！</div>
  <div>初めまして{{::myName}}さん！</div>

One-time Bindingは、式の前にコロンを２つ付与するだけです。
	
