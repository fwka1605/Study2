<element ng-repeat="var in list">
</element>
	
element:繰り返し対象の要素
var:仮変数
list:処理対象の配列
	
例
	
<table class="table">
	<tr>
		<th>ISBNコード</th>
		<th>書名</th>
		<th>価格</th>
		<th>出版社</th>
		<th>刊行日</th>
	</tr>
	<tr ng-repeat="book in books">
		<td>{{book.isbn}}</td>
		<td>{{book.title}}</td>
		<td>{{book.price}}円</td>
		<td>{{book.publish}}</td>
		<td>{{book.published | date:'yyyy年MM月dd日'}}</td>
	</tr>
</table>	
	
例１：オブジェクト（ハッシュ）の処理
	
angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.author={
      name:'YAMADA, Yoshihiro',
      gender:'male',
      birth:new Date(1950,11,4)
    };
  }]);

<table class="table">
  <tr ng-repeat="(key,value) in author">
    <th>{{key}}</th>
    <td>{{value}}</td>
  </tr>
</table>

例２：(キー変数,値変数) in オブジェクト
(key,value) in author
	
これによって、オブジェクトのキー（プロパティ名）、値が、
それぞれ順にキー変数/値変数にセットされる。

例３：ng-repeatループ配下で利用できる特殊変数

$index	:インデックス番号(0～length-1)
$first	:最初の要素であるか。(true/false)
$middle	:最初と最後の要素でないか。(true/false)
$last	:最後の要素であるか。(true/false)
$even	:$indexが偶数か。(true/false)
$odd	:$indexが奇数か。(true/false)

angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.years = ['子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥'];
  }]);

<table class="table">
  <tr>
    <th>値</th>
    <th>$index</th>
    <th>$first</th>
    <th>$middle</th>
    <th>$last</th>
    <th>$odd</th>
    <th>$even</th>
  </tr>
  <tr ng-repeat="value in years">
    <td>{{value}}</td>
    <td>{{$index}}</td>
    <td>{{$first}}</td>
    <td>{{$middle}}</td>
    <td>{{$last}}</td>
    <td>{{$odd}}</td>
    <td>{{$even}}</td>
  </tr>
</table>

例３：異なる要素のセットを繰り返し出力する
	
angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.articles = [
      {
        title: 'サーブレット＆JSPポケットリファレンス',
        body: 'Javaエンジニアには欠かせないサーブレット＆JSPのリファレンス。サーブレット3.1＆JSP2.3に対応。',
        author: '山田祥寛'
      },
      {
        title: 'iPhone／iPad開発ポケットリファレンス',
        body: 'スマホやタブレットの代名詞といえるiPhone/iPadでアプリ開発するための知識をまとめたリファレンスが登場。',
        author: '片渕彼富'
      },
      {
        title: 'Java ポケットリファレンス',
        body: '忘れてしまいがちな基本情報をコンパクトなサイズに凝縮。逆引きで目的からすぐに探せて、サンプルで具体的な実装イメージをつかめます。',
        author: '高江賢'
      },
    ];
  }]);


<header ng-repeat-start="article in articles">{{article.title}}</header>
<div>{{article.body}}</div>
<footer ng-repeat-end>{{article.author}}</footer>

例えば、HTMLのheader/div/footer要素のような異なる要素の組み合わせで
ループをしたい場合は、親要素を追加する方法以外に以下の方法がある。
	
この場合はループの開始要素(header)に、ng-repeat-start="var in list"と指定し、
ループの終了要素(footer)にng-repeat-endのディレクティブを付与すればよい。
このng-repeat-startとng-repoeat-endに挟まれた要素でもループから取り出した
値を利用することができる。
	
例４：重複した配列
	
angular.module('myApp', [])
  .controller('MyController', ['$scope', function($scope) {
    $scope.books = [
      'サーブレット＆JSPポケットリファレンス',
      'アプリを作ろう！Android入門',
      'ASP.NET MVC 5実践プログラミング',
      'JavaScript逆引きレシピ',
      'サーブレット＆JSPポケットリファレンス'
    ];
  }]);

<li ng-repeat="book in books">{{book}}</li>

重複した配列booksを上記のようにng-repeatで出力すると、以下のエラーになる。
	
Duplicates in a repeater are not allowed. Use 'track by' expression to 
specify unique keys. Repeater: book in books, Duplicate key: string:
サーブレット＆JSPポケットリファレンス, Duplicate value: サーブレット＆JSPポケットリファレンス

上記は'サーブレット＆JSPポケットリファレンス'が重複しているから
エラーになる。

ng-repeatディレクティブは、デフォルトでは、配列内の要素値をキーに
繰り返し項目の増減等を管理/追跡（トラッキング）している。
そのため、同じ文字列に対しては「すでにその値は管理に使われている」と
エラーになってしまう。
これを避けるためにトラッキング対象の項目を要素値から別の項目に変更する
必要がある。 そのための利用するのがトラッキング式になる。
この式により、繰り返し項目の増減等を管理/追跡する項目を指定することができる。

<li ng-repeat="book in books track by $index">{{book}}</li>

上記のtrack by $indexによりトラッキング項目を配列のインデックス($index)で
要素を管理しなさいという指定になっている。インデックス値は重複しないので、
正しく要素が表示されることになる。
	
例５：ng-class-even と ng-class-odd について

ng-class-evenとng-class-oddは、ng-repeatとセットで利用することを想定された
ディレクティブである。
ng-class-evenとng-class-oddは、それぞれ偶数行と気数行で指定するclass属性を
指定するディレクティブである。
	




















