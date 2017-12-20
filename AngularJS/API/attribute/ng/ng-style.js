<element ng-style="プロパティ名と値のハッシュ値" />

要素に対してスタイルプロパティを設定する最もシンプルな方法は、
ng-styleディレクティブを利用することです。
	
ng-styleディレクティブは、適用すべきスタイル情報を
プロパティ名:値のハッシュ値の形式で指定します。

設定するプロパティ名は、CSS形式であるbackground-colorではなく、
camelCase形式のbackgroundColorで指定する必要がある。
なぜならば、JavaScriptではプロパティ名にハイフンを利用できない
からである。ただし、プロパティ名をダブルコーテーションで囲む
場合はハイフン形式を利用することができる。

例：
<form>
  <button ng-click="myStyle={ backgroundColor: '#f00', color: '#fff' }">
    赤</button>
  <button ng-click="myStyle={ backgroundColor: '#0f0' }">緑</button>
  <button ng-click="myStyle={ backgroundColor: '#00f', color: '#fff' }">
    青</button>
</form>
<div ng-style="myStyle">
  <p>WINGSプロジェクトは、当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</div>
	
