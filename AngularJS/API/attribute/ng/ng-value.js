<element ng-value="var">
</element>
	
element:input(type=radio or select)
var:スカラー値や配列・ハッシュ
	

例：
<div>
<label>
  <input type="radio" ng-model="value" ng-value="scalarValue" name="exp" />
  スカラー値  
</label>
<label>
  <input type="radio" ng-model="value" ng-value="arrayValue" name="exp" />
  配列  
</label>
<label>
  <input type="radio" ng-model="value" ng-value="hashValue" name="exp" />
  ハッシュ  
</label>
</div>
選択された値：{{value}}

angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.scalarValue = 'スカラー値';
    $scope.arrayValue = [ 'あいうえお', 'かきくけこ', 'さしすせそ' ];
    $scope.hashValue = { name: '山田理央', sex: '男', age: 8 };
  }]);
