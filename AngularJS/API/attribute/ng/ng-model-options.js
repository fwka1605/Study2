<element ng-model-options="var">
</element>
	
element:input/textarea/selectなどのフォーム要素
var:パラメータ:値のハッシュ形式で指定
	updateOn	モデルを更新するトリガーとなるイベント（空白区切りで複数指定可能）
	debounce	モデルの更新まで待機する時間（ミリ秒）
	allowInvalid	不正なモデル値を許容するか
	getterSetter	モデルに値を設定する際、getter/setterを利用するか
	timezone	タイムゾーンを指定
	
ng-model-options属性を利用することで、モデルを更新するタイミング/方法
などを設定することができます。

注意：
ng-model-options属性の設定は、現在の要素だけでなく、子孫要素にも
影響します。 

	
例
	
１．updateOn
	
<label for="name">名前：</label>
<input id="name" name="name" type="text" ng-model="myName" 
  ng-model-options="{ updateOn: 'blur' }" />
<div>こんにちは、{{myName}}さん！</div>
	
updateOnパラメータを指定しているので、blurイベント（フォーカスロス時）に
モデルに値を更新するように限定できます。

２．debounce
	
<label for="name">名前：</label>
<input id="name" name="name" type="text" ng-model="myName" 
 ng-model-options="{ updateOn: 'default blur',
                     debounce: {'default': 2000, 'blur': 0}
                   }" />
<div>こんにちは、{{myName}}さん！</div>

updateOnパラメータではdefault(標準：値更新時にモデルに反映)、blur(フォーカスロス時に
モデルに反映）を指定し、debouceでは、defaultの場合は2000ミリ秒後にモデルに反映し、
blur時には0ミリ秒（即時）にモデルに反映するように指定する。
	
３．allowInvalid

  <form name="myForm" novalidate>
  <div>
    <input id="mail" name="mail" type="email" ng-model="email"
      ng-model-options="{ allowInvalid: false }" required />
  </div>
  <div>入力値：{{email}}</div>
  </form>

デフォルトでは、フォーム要素の値が不正である場合には、AngularJSは対応するモデル
(ng-model属性)に対してundefined値をセットします。 しかし、不正な値でもいったん
アプリ側で受け取って、なんらかの処理を施したいという場合には、allowInvalidパラメータ
をtrueにします。
	
上記の場合は、allowInvalidがfalseの場合は、おかしなメアドの場合はemailに反映されず、
正しいメアドの時だけemailに反映されます。
trueの場合はメアドの内容に関係なく値が反映されます。

４．getter/setter

  <label for="name">名前：</label>
  <input id="name" name="name" type="text" ng-model="my.name" 
    ng-model-options="{ getterSetter: true }" />
  <div>こんにちは、<span ng-bind="my.name()"></span>さん！</div>

angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.my = {
      _name: '権兵衛',
      name: function(name) {
        if (angular.isUndefined(name)) {
          return this._name;
        } else {
          this._name = name;
        }
      }
    };
  }]);

getterSetterパラメータをtrueにした場合は、ng-model属性に紐づいた関数を
getter/setterとして処理します。
入力値を加工して設定する、または加工して返す場合などに利用できる。
	
５．timezone
	
<input id="today" name="today" type="time" ng-model="today" 
  ng-model-options="{ timezone: '+0800' }" />
<div>{{today | date: 'medium'}}</div>

timezoneパラメータを利用することで、<input type="date">/<input type="time">
要素を扱う際のタイムゾーンを+HHMMの形式で指定できます。
	



注意点
	
<form name="myForm">
  <label for="myName">名前：</label>
  <input id="myName" name="myName" type="text" ng-model="myName" 
    ng-model-options="{ debounce: 5000 }" />
  <div ng-bind="'こんにちは、' + myName + 'さん！'"></div>
  <button ng-click="onclick()">ログ出力</button>
</form>
	
angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.onclick = function() {
      $scope.myForm.myName.$rollbackViewValue();
      console.log($scope.myName);
    };
  }]);
  
updateOn/deboundeパラメータを指定した場合、フォーム要素とモデル間で
見た目の不一致が発生する可能性がある。
例のように5000ミリ秒にモデルに反映される前にログ出力ボタンを押すと、
ログの方はundefinedと表示されるが、ブラウザは5000ミリ秒経過すると
入力した値が表示される。
これを回避する方法としては、ログ出力ボタンをクリック時に、まだモデル
反映されていない値（保留中の値）をロールバックする方法がある。
それを行うのが上記の、$scope.myForm.myName.$rollbackViewValue();の
部分である。

 
