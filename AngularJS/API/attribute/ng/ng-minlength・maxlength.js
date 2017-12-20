<element ng-minlength="var">
</element>
	
<element ng-maxlength="var">
</element>
	
element:input/textarea/selectなどのフォーム要素
var:最大または最小の文字数の数値

ng-minlenght または ng-maxlengthを指定することで、
入力文字の最大長と最小長の入力チェックを行える。	
	
例
<div>
  <label for="name">名前（漢字）：</label><br/>
  <input id="name" name="name" type="text" ng-model="user.name" ng-minlength="3" ng-maxlength="10" />  
  <span ng-show="myForm.name.$error.minlength">
    名前（漢字）は3文字以上で入力してください。
  </span>
  <span ng-show="myForm.name.$error.maxlength">
    名前（漢字）は10文字以上で入力してください。
  </span>
</div>
入力された値:{{user.mail}}