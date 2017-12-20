<details ng-show="flag">
	<summary></summary>
</details>

ng-openは、ng-if/ng-show/ng-hideと同じく、
表示/非表示のためのディレクティブです。
	
ただし、ng-openは対象となる要素が<details>要素
だけであるという点が異なります。	

details要素は、HTML5で新たに追加された要素で、
追加（詳細）情報を見せるためのUIを提供します。

例
<body ng-controller="MyController">
<form>
  <label for="show">表示／非表示：</label>
  <input id="show" type="checkbox" ng-model="show" />
</form>
<details id="panel" class="panel panel-default" ng-open="show">
  <summary>WINGSプロジェクトは、執筆コミュニティです。</summary>
  <p>当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</details>
</body>
