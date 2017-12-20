<element ng-required="var">
</element>
	
	
element:input/textarea/などのフォーム要素
var:必須か否かの真偽値

	
例
<div>
  <label for="mail">メールアドレス</label><br/>
  <input id="mail" name="mail" type="email" ng-model="user.mail" required />
  <span ng-show="myForm.mail.$error.required">
    メールアドレスは必須ですよ
  </span>
  <span ng-show="myForm.mail.$error.email">
    メールアドレスを正しい形式で入力してくださいよ
  </span>
</div>
	
〇注意

HTML5のrequiredとng-required属性の相違点
	
共に必須かどうかをチェックするための属性になる。
	
requiredはHTML5の属性で、AngularJSはこれを認識して、
この属性があれば必須チェックを有効にします。
そのため、通常はng-requiredではなくrequiredだけを
使用すれば問題はない。

ng-requiredを利用する場合としては、必須チェックを
動的に行いたい場合である。

<form name="myForm" ng-submit="onsubmit()" novalidate>
  <div>
    <label for="send">メール送信：</label><br />
    <input id="send" name="send" type="checkbox" ng-model="user.send" />
  </div>
  <div>
    <label for="mail">メールアドレス：</label><br />
    <input id="mail" name="mail" type="email" ng-model="user.mail"
      ng-required="user.send" />
    <span ng-show="myForm.mail.$error.required">
      メールを送信する場合、メールアドレスは必須です。</span>
    <span ng-show="myForm.mail.$error.email">
      メールアドレスを正しい形式で入力してください。</span>
  </div>
</form>
	
上記いうと、メール送信にチェックが入っている場合だけ
メールの必須チェックを行うことになる。

