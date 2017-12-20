<element ng-show="var" >
	～
</element>

var :真偽値

ng-show属性は、真の場合にその要素を表示し、
偽の場合はその要素を非表示にする。
	
例：
  <span ng-show="myForm.name.$error.required">
    名前（漢字）は必須です。
  </span>
  <span ng-show="myForm.name.$error.minlength">
    名前（漢字）は3文字以上で入力してください。
  </span>
  <span ng-show="myForm.name.$error.maxlength">
    名前（漢字）は10文字以上で入力してください。
  </span>