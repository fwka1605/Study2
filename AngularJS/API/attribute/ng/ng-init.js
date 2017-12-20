<element ng-init="var">
</element>
	
element:input/textarea/selectなどのフォーム要素
var:初期値

ng-init属性を利用することで、モデルの初期値をコントローラー側ではなく、
テンプレート側で設定することができます。

一般に、モデルの初期値はコントローラで設定することが基本ですが、
例えば、テキストボックスの初期値など、その場限りで利用するだけの
値を設定するときなどにng-iniを使用すると便利です。
	
	
例
<div>
  <label for="mail">メールアドレス</label><br/>
  <input id="mail" name="mail" type="email" ng-model="user.mail"
    ng-init="user.mail='test@test.co.jp'" />  
</div>

入力された値:{{user.mail}}