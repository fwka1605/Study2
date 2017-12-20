<parent ng-messages-exp="exp" ng-messages-multiple>
</parent>

ng-messages属性で利用するメッセージをJavaScript側で
	管理することができます。

例
	
<form name="myForm" novalidate>
  <div>
    <label for="mail">メールアドレス：</label><br />
    <input id="mail" name="mail" type="email" ng-model="user.mail"
      required ng-minlength="10" ng-maxlength="20" />
    <span ng-messages="myForm.mail.$error" ng-messages-multiple>
      <span ng-message="minlength, maxlength">
        10～20文字の範囲で入力してください。</span>
      <span ng-repeat="error in errors">
        <span ng-message-exp="error.type">{{error.message}}</span>
      </span>
    </span>
  </div>
</form>
	
angular.module('myApp', [ 'ngMessages' ])
  .controller('MyController', ['$scope', function($scope) {
    $scope.errors = [
      { type: 'required', message: '入力は必須です。' },
      { type: ['minlength', 'maxlength'], message: '入力値が短すぎます。' },
      { type: 'email', message: '正しいメール形式で入力してください。' }
    ];
  }]);
