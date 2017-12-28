サンプルコードの実行方法

1. Androidもしくは、iOSのプラットフォームをインストール

Androidの場合
$cordova platform add android

iOSの場合
$cordova platform add ios

2. プラグインの追加

$cordova plugin add cordova-plugin-file
$cordova plugin add cordova-plugin-file-transfer

3. 実行

各環境に合わせて、実行して下さい。
以下の例は、Android（実機）での実行方法です。
$cordova run android --device

4. その他
サンプルコードには一部、サーバと連携した部分があり、以下のファイルを書き換えることで正常に動作します。
app/www/js/controllers/FileTransferController.js    ( Line : 8,45 )

また、サーバ側のサンプルコードはserverフォルダにあります。