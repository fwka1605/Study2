<element ng-if="ブール値"></element>
	
ブール値に応じて、現在の要素の表示非表示を切り替えます。
そのため、JavaScriptのif命令に相当します。
	
例：
<body ng-controller="MyController">
<form>
  <label for="show">表示／非表示：</label>
  <input id="show" type="checkbox" ng-model="show" />
  <button ng-click="onclick()">背景反転</button>
</form>
<div id="panel" class="panel panel-default" ng-if="show">
  <p>WINGSプロジェクトは、当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</div>
</body>
	
ng-ifにshowを指定し、そのshowをチェックボックスとモデルで紐づけています。

注意点

ng-ifディレクティブによる表示・非表示の切り替えは、スタイルシートの操作ではなく、
該当要素そのものを文書ツリーから破棄しています。
つまり、上記で言えばshowがfalseならば、idがpanelのdiv要素自体がDOMツリーから
なくなります。
	
そのため、div要素を表示中にそのスタイル等の状態を変更してから、div要素のng-ifを
falseにするとdiv要素が破棄されるため、div要素を再度表示した際には、以前の状態を
保持しているわけではなく、作成された直後の初期状態に戻ってしまう。
	
これを避けるためには、ng-ifディレクティブの代わりに、ng-show/ng-hideディレクティ
を利用して、DOMツリーの変更はなく、スタイルの切り替えによる表示・非表示のディレクティブ
を利用すべきである。