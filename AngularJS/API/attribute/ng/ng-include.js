<element ng-include="var">
</element>
	
var:取り込むファイルの相対パス

ng-include属性（ディレクティブ）を利用することで、別ファイルで
用意されたテンプレートを動的にインクルードすることができます。
	
<div ng-include="template"></div>
	
上記では、変数templateの値に応じて読み込むべきテンプレートを切り替えています。

<div ng-include src="template"></div>

また上記のようにsrc属性で指定しても良い。

さらに、テンプレートを反映させるべき親要素がない場合は、ng-includeを要素
として指定することもできます。
この場合は、src属性は必須になります。

<ng-include src="template"></ng-include>
	
ng-includeディレクティブの属性
	
1.onload テンプレート呼び出しのタイミングで実行する式
2.autoscroll プール属性 自動スクロール機能($anchorScroll)を有効にするか

	
例
	
<form>
  <div>
    <label for="temp">テンプレート：</label>
    <select id="temp" name="temp" ng-model="template"
      ng-options="t.url as t.title for t in templates">
      <option value="">以下から選択してください。</option>
    </select>
  </div>
  <div class="box" ng-include="template" onload="onload()"></div>
</form>