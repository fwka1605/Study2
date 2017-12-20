<element ng-diable="var">
</element>
	
var:真偽値

ng-disable属性は、値が真の場合はその要素を非活性にし、
偽の場合は活性にする。
	
入力エラーがなければ登録ボタンを有効にするなどで
利用される。

例
<div>
  <input type="submit" value="登録" ng-disabled="myForm.$invalid" />
</div>
