import sys
from urllib.request import Request
from urllib.request import urlopen

url="http://gihyo.jp/dp"	

headers = {	
        "User-Agent": "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0",	
        }	

request = Request(url=url, headers=headers)	

f = urlopen(request)	

encoding = f.info().get_content_charset(failobj="utf-8")

print('encoding:',encoding,file=sys.stderr)

text = f.read().decode(encoding)

print(text)


