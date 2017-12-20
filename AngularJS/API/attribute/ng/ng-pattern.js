<element ng-pattern="正規表現式">
</element>
	
	
element:input/textarea/などのフォーム要素

	
例
  <div>
    <label for="zip">郵便番号：</label><br />
    <input id="zip" name="zip" type="text" ng-model="user.zip"
      ng-pattern="/^[0-9]{3}-[0-9]{4}$/" />
    <span ng-show="myForm.zip.$error.pattern">
      郵便番号は「999-9999」の形式で入力してください。  
    </span>
  </div>
    	
