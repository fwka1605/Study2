<element ng-event="">…</element>
	
evelent:任意の要素
event:任意のイベント（ここにclickなどがくる）

例
<form>
  <label for="name">名前：</label> 
  <input id="name" name="name" type="text" ng-model="myName" />
  <button ng-click="onclick()">送信</button>  
</form>

ng-click：クリック時
ng-dblclick:ダブルクリック時
ng-mousedown:マウスボタンを押したとき
ng-mouseup:マウスボタンを離した時
ng-mouseenter:マウスポインターが要素に入ったとき
ng-mouseover:マウスポインターが要素に乗ったとき
ng-mouseleave：マウスポインターが要素から離れるとき
ng-focus：要素にフォーカスした時
ng-blur：要素からフォーカスが外れたとき
ng-keydown：キーを押した時
ng-keypress：キーを押し続けている時
ng-keyup：キーを話した時
ng-change：値の変更時
ng-copy：コピー時
ng-cut：カット時
ng-paste：ペースト時
ng-submit：サブミット地
	