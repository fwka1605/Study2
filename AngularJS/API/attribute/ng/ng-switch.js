<parent ng-switch="exp">
	<child ng-switch-when="value1">...</child>
	<child ng-switch-when="value2">...</child>
	...
	<child ng-switch-default>...</child>
</parent>
	
parent,child:任意の要素
exp:式
value1,value2:式の値	
	
式(ng-switch属性)の値に合致するng-switch-when属性を
持つ要素が表示される。仮に複数のng-switch-whenに一致
した場合は全て表示される。

ng-if/ng-show/ng-hideの組み合わせでも実現できるが、
条件式を個別に書く必要がある。 そのため、式の値に
基づいて多岐分岐するのであれば、ng-switchを優先して
利用する。

例：
<select ng-model="season">
  <option value=""></option>
  <option value="spring">春</option>
  <option value="summer">夏</option>
  <option value="autumn">秋</option>
  <option value="winter">冬</option>
</select>

<div ng-switch="season">
  <span ng-switch-when="spring">春を選択</span>
  <span ng-switch-when="summer">夏を選択</span>
  <span ng-switch-when="autumn">秋を選択</span>
  <span ng-switch-when="winter">冬を選択</span>
</div>
