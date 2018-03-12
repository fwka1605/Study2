import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import requests
import lxml.html

response=requests.get('https://gihyo.jp/dp')

root=lxml.html.fromstring(response.content)

#すべてのリンクを絶対URLに変換する
root.make_links_absolute(response.url)

for a in root.cssselect('#listBook a[itemprop="url"]'):
	url = a.get('href')
	print(url)
