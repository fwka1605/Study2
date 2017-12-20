<form nng-submit="onsubmit()" >
  <input type="submit" value="登録" />
</form>	

サブミット時に呼び出すJSを指定する。
		
angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.onsubmit = function() {
    };
  }]);

注意
ng-submit属性は、<form>要素にaction属性がない場合は、サーバーへ
POSTまたはGET要求を送りません。
	
シングルページ（１つのページでアプリを完結させる考え）とうい点から
すれば、これは理にかなった仕様になります。