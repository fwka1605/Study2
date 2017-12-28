サンプルコードの実行方法

1. Androidもしくは、iOSのプラットフォームをインストール
Androidの場合
$cordova platform add android

iOSの場合
$cordova platform add ios

2. プラグインの追加
$cordova plugin add cordova-plugin-calendar --variable CALENDAR_USAGE_DESCRIPTION="カレンダーを利用します"
$cordova plugin add cordova-plugin-device

下記、プラグインはデザイン上のためのみ使用
$cordova plugin add cordova-plugin-statusbar

3. 実行
各環境に合わせて、実行して下さい。
以下の例は、Android（実機）での実行方法です。
$cordova run android --device