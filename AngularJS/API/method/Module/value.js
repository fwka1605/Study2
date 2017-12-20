value(name,object)
	
〇戻り値
Moduleオブジェクト
※Moduleオブジェクトのメソッドのほとんどは
　戻り値として自分自身（Moduleオブジェクト）を
　返します。 この性質を利用してメソッドチェーンで呼び出せます。
	
〇引数
name	サービス名名
object	サービスのインスタンス（任意の型）
	
〇例
	
angular.module('myApp', [])
	.controller('MyController', function($scope,BookList){
	    $scope.books = BookList();
	})
	.value('BookList',function(){
		return 
	    [
	      {
	        isbn: '978-4-7741-7078-7',
	        title: 'サーブレット＆JSPポケットリファレンス',
	        price: 2680,
	        publish: '技術評論社',
	        published: new Date(2015, 0, 8)
	      },
	      {
	        isbn: '978-4-8222-9634-6',
	        title: 'アプリを作ろう！Android入門',
	        price: 2000,
	        publish: '日経BP',
	        published: new Date(2014, 11, 20)
	      }
	    ];		
	});