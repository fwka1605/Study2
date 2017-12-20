<select>
	<option value="easy"></option>
	<option value="usually" ng-selected="selected"></option>
</select>
	
selected :真偽値を返すAngular式

ng-selected属性は、式の戻り値が真の場合にそのオプションを
選択します。	
	
例：
<form>
<label>
  <input type="checkbox" ng-model="selected" />標準を選ぶ
</label>
<select>
  <option value="easy">かんたんコース</option>
  <option value="usually" ng-selected="selected">ふつうコース</option>
  <option value="difficulty">むずかしいコース</option>
</select>
</form>
	
上記の例では、checkboxのtrue/falseがselectedモデルと連動し、ng-selectedディレクティブ
で ふつうコース と連動しているため、 checkboxをONにすると ふつうコースが
選択されることになる。
	
