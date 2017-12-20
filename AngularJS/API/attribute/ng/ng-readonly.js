<element ng-readonly="var">
</element>
	
	
element:input/textarea/などのフォーム要素
var:読取専用か否かの真偽値

	
例
<form name="myForm" novalidate>
  <div>
    <label for="mail">メールアドレス：</label><br />
    <input id="mail" name="mail" type="email" ng-model="user.mail"
      ng-readonly="!canedit" />
    <label>
      <input type="checkbox" ng-model="canedit" />
      編集可
    </label>
  </div>
</form>	

ng-modelで指定しているcanceditがチェックありの場合は、
ng-readonly="!canedit"がfalseになるため、inputのmailが
readonlyでなくなる。