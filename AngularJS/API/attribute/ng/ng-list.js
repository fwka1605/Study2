<element ng-list="delimiter">
</element>
	
element:input/textarea/selectなどのフォーム要素
delimiter:区切り文字

テキストボックスやテキストエリアに入力された内容を
delimiterで指定した区切り文字で分割し、配列化する
ディレクティブになる。
	
例
<form>
  <label for="mail">メールアドレス：</label><br />
  <textarea id="mail" type="text" ng-model="emails" ng-list=";"></textarea>
</form>
<ul>
  <li ng-repeat="email in emails track by $index">{{email}}</li>
</ul>

$indexを付けているのは、文字列の重複を許しているためです。