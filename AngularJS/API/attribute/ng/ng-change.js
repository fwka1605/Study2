<element ng-change="onChange()" />

element:全てのフォーム要素で利用できる
	
入力値に変更があった場合に実行される式を指定する

例
		
<form>
  <div>
    <label><input type="checkbox" name="all" ng-model="all"
      ng-change="onchange()" />すべてチェック</label><br />
    <label ng-repeat-start="book in books">
      <input type="checkbox" ng-model="data.book[book.isbn]" ng-checked="all"
         ng-true-value="true" ng-false-value="false" id="isbn{{book.isbn}}"
         name="book{{book.isbn}}" />
      {{book.title}}</label>
    <br ng-repeat-end />
  </div>
  選択された値：{{data.book}}
<hr />
	
   $scope.onchange = function() {
      for (var i = 0; i < $scope.books.length; i++) {
        var isbn = $scope.books[i].isbn;
        $scope.data.book[isbn] = $scope.all;
      }
    };