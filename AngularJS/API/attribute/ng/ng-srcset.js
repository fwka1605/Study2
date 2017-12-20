<img ng-rscset="http://{{url}}" />

url :パスの一部

ng-src/ng-srcset属性は、ng-href属性と同じく、
<img>要素のsrc/srcset属性をAngular式で動的に
設定するために利用します。
	
Angular式を含むテンプレートをsrc/srcset属性にセットしては
ダメな理由は、ng-href属性と同じになります。
処理が完了する前の無効なURLで画像ファイルを取得しようとする
ためです。
	
例：
<img ng-src="http://www.wings.msn.to/books/{{isbn}}/{{isbn}}.jpg" />

参考：src/srcset
	
srcset属性は、HTML5から追加された属性になります。

< img 
	src =" images/ hoge. jpg" 
	srcset =" images/ hoge.jpg 1x, images/ hoge2.jpg 2x" />

srcset属性は、カンマ区切りで「画像URL条件」の形式で指定します。
xはデバイスピクセル比を表します。

デバイス・ピクセル比とは、1ピクセルの画像データをディスプレイが
何ピクセルで表現するかを表す数値のことです。

この場合は通常のデバイス(x1：1ピクセルを1ピクセルで表す)であれば、
通常の画像であるであるhoge.jpgを利用する。
高解像度なデバイス(x2:1ピクセルを2ピクセルで表す）であれば、
高解像度用の画像のhoge2.jpgを使用します。
	
また、src属性は下位互換性の指定になり、srcset属性が指定されていれば
無視されます。