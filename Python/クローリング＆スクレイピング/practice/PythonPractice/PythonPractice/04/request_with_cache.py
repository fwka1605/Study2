import sys


sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib/python2.7/site-packages')
sys.path.append('/usr/lib/python2.7/dist-packages')

import requests
from cachecontrol import CacheControl

session = requests.session()

#sessionをラップ下cached_sessionを作る。
cached_session = CacheControl(session)

#一回目はキャッシュがないので、サーバーから取得しキャッシュする
response = cached_session.get('http://gihyo.jp/')
print(response.from_cache)

#二回目はETagとLast-Modifiedの値を使って更新されているかを確認する。
#更新されていない場合のコンテンツはキャッシュから取得するので高速に処理できる
response = cached_session.get('http://gihyo.jp/')
print(response.from_cache)
