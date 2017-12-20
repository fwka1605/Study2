<parent ng-messages="exp" ng-messages-multiple>
	<child ng-message="prop1">表示するメッセージ</child>
	<child ng-message="prop2">表示するメッセージ</child>
	～
</parent>

parent/child：任意の要素
exp：真偽値を返す式
prop1,prop2:検証キー
ng-message-multiple ：エラーが複数ある場合に複数表示できます。

ng-messagesディレクティブ（ngMessagesモジュール）は、
AngularJSのコア（angular.min.js)には含まれていません。
HTML側ではangular-messages.min.jsをインポートする必要があり、
JavaScript側ではngMessagesモジュールへの依存関係を指定する
必要があります。

参考：
ng-messages/ng-messageディレクティブは、俗世ではなく、要素の形式で
呼び出すこともできます。
	

例
	
<form name="myForm" novalidate>
  <div>
    <label for="mail">メールアドレス：</label><br />
    <input id="mail" name="mail" type="email" ng-model="user.mail"
      required ng-minlength="10" ng-maxlength="20" />
    <!--<span ng-messages="myForm.mail.$error">-->
    <span ng-messages="myForm.mail.$error" ng-messages-multiple>
      <span ng-message="required">入力は必須です。</span>
      <span ng-message="minlength, maxlength">
        入力値が短すぎるか、長すぎます。</span>
      <span ng-message="email">正しいメール形式で入力してください。</span>
    </span>

<!--要素構文で書き換えた例-->
<!--
    <ng-messages for="myForm.mail.$error">
      <ng-message when="required">入力は必須です。</ng-message>
      <ng-message when="minlength, maxlength">入力値が短すぎるか、長すぎます。</ng-message>
      <ng-message when="email">正しいメール形式で入力してください。</ng-message>
    </ng-messages>
-->
  </div>
</form>