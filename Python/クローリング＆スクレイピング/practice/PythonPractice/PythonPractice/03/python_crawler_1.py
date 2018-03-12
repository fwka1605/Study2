import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import requests
import lxml.html

response=requests.get('https://gihyo.jp/dp')

root=lxml.html.fromstring(response.content)

for a in root.cssselect('a[itemprop="url"]'):
	url = a.get('href')
	print(url)
