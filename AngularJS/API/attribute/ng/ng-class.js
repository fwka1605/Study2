<element ng-class="クラス名" />

ng-styleディレクティブではスタイルを直接指定するため、
手軽であるが、問題もある。
	
	
それは、テンプレート内にデザインの指定の記述が入り込む
からである。

そのため通常は、ng-classディレクティブを利用し、ng-classは、
あらかじめ要したスタイルクラスを割り当てる。

これにより、プログラマとデザイナの分業も容易になる。

例：
<body ng-controller="MyController">
<form>
  <button ng-click="myStyle='red'">赤</button>
  <button ng-click="myStyle='green'">緑</button>
  <button ng-click="myStyle='blue'">青</button>
</form>
<div ng-class="myStyle">
  <p>WINGSプロジェクトは、当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</div>
</body>

またクラス名は、クラス名の配列を指定することができる。

<body ng-controller="MyController">
<div ng-class="['back', 'chara', 'space']">
  <p>WINGSプロジェクトは、当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</div>
</body>

また以下のようにプロパティ名：値のハッシュ値で指定し、
値をモデルと紐づけて指定することもできる。
	
<body ng-controller="MyController">
<form>
  <label><input type="checkbox" ng-model="bBack" />背景</label>
  <label><input type="checkbox" ng-model="bChara" />フォント</label>
  <label><input type="checkbox" ng-model="bSpace" />余白</label>
</form>
<div ng-class="{ back: bBack, chara: bChara, space:bSpace }">
  <p>WINGSプロジェクトは、当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</div>
</body>
</html>
	
さらに、クラス名の指定と、プロパティ名：値の指定を混在させることもできる。
		
<body ng-controller="MyController">
<form>
  <label><input type="checkbox" ng-model="bSpace" />余白</label>
</form>
<div ng-class="['back', 'chara', { space: bSpace }]">
  <p>WINGSプロジェクトは、当初、ライター山田祥寛のサポート（検証・査読・校正作業）集団という位置づけで開始されたコミュニティでしたが、2002年12月にメンバを大幅に増強し、本格的な執筆者プロジェクトとして生まれ変わりました。</p>
  <p>その後、「基礎PHP」インプレス）の執筆を皮切りに、「Java PRESS」「Web+DB PRESS」（技術評論社）、「＠IT」（IT Media）、「CodeZine」（翔泳社）のような紙／ネットワークを問わず、広い媒体で実績を積んで、現在に至ります。</p>
  <p>2005年5月には「有限会社 WINGSプロジェクト」として法人化を果たし、ますます質の高い情報を読者の方々にお届けしてまいります。</p>
</div>
</body>