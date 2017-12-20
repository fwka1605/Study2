<input type="select" ng-options="var">
</input>
	
ng-options属性を使用すれば、動的にoptionを作成できます。

ng-options属性では、プレースフォルダーは作成されません。
そのため、<option value="">以下から選択してください。</option>
などの指定を自分で行う必要があります。

例

１．ラベルテキスト for 要素 in 配列

<select id="book" name="book" ng-model="data.book"
	ng-options="book.title for book in books">
	
ラベルテキストを表示、モデルには配列要素自身が渡されます。
	
２．選択値 as ラベルテキスト for 要素 in 配列

<select id="book" name="book" ng-model="data.book"
	ng-options="book.isbn as book.title for book in books">
	
ラベルテキストを表示、モデルにはisbnプロパティが渡されます。

３．ラベルテキスト group by グループ化キー for 要素 in 配列
	
    <select id="book" name="book" ng-model="data.book"
      ng-options="book.title group by book.publish for book in books">

group by句を使用することで、特定のキーで配列の内容をグループ化できます。

グループ化を有効にした場合は、選択オプションは<optgroup>要素でグループ化
され、グループ化キーの値がそのまま<optgropu>要素のラベルテキストとなります。
	
４．２と３の混合

    <select id="book" name="book" ng-model="data.book"
      ng-options="book.title as book.isbn group by book.publish for book in books">

５．特定のオプションの無効化

    <select id="book" name="book" ng-model="data.book"
      ng-options="book.isbn as book.title disable when book.deleted for book in books">
      <option value="">以下から選択してください。</option>
    </select>

book.deletedがtrueの場合は、このオプションは無効（表示するが選択不可）になります。

６．選択 as ラベル for (キー,値) in オブジェクト
	
配列ではなく、オブジェクトのキー/値を元に選択オプションを列挙することもできます。
	
ISBNコードをキーに、書籍オブジェクトを持つshelfオブジェクトを選択ボックスに
展開する例です。
	
    <select id="book" name="book" ng-model="data.book"
      ng-options="key as value.title for (key, value) in shelf">
      <option value="">以下から選択してください。</option>
    </select>
    	
angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.shelf = {
      '978-4-7741-7078-7': {
        title: 'サーブレット＆JSPポケットリファレンス',
        price: 2680,
        publish: '技術評論社',
        published: new Date(2015, 0, 8)
      },
      '978-4-8222-9634-6': {
        title: 'アプリを作ろう！Android入門',
        price: 2000,
        publish: '日経BP',
        published: new Date(2014, 11, 20)
      }
      ～
    };
  }]);

７． 選択値 as ラベルテキスト group by グループ化キー for (キー,値) in ハッシュ

    <select id="book" name="book" ng-model="data.book"
      ng-options="key as value.title group by value.publish for (key, value) in shelf">
      <option value="">以下から選択してください。</option>
    </select>

配列と同様に、ハッシュで<optgroup>要素月の選択ボックスを生成することもできます。
