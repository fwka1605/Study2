<element ng-plurlize count="var.length" offset="num">
</element>

count:配列の要素数
offset:{}で表示する件数のオフセットを設定する。
	offset=2で配列要素数が5の場合は{}は3になる。
when:カウントに応じたメッセージのパターンを指定する。
plurlizeは複数化の意味

例：
<div ng-pluralize count="my.favs.length" offset="2" 
  when="{
    '0':'[いいね！]されていません。',
    '1':'{{my.favs[0]}}さんが[いいね！]といっています。',
    '2':'{{my.favs[0]}}さん、{{my.favs[1]}}さんが[いいね!]と言っています。',
    'one':'{{my.favs[0]}}さん、{{my.favs[1]}}さんとあと１名が[いいね!]と言っています。',
    'other':'{{my.favs[0]}}さん、{{my.favs[1]}}さん、他{}名が[いいね!]と言っています。'
  }" >
</div>
	