import sys


sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib/python2.7/site-packages')
sys.path.append('/usr/lib/python2.7/dist-packages')

from voluptuous import Schema,Match

schema = Schema({
                #ルール１:オブジェクトはdictである。
                #ルール２:nameの値は文字列である。
                'name':str,
                #ルール３:priceの値は正規表現にマッチする
                'price':Match(r'^[0-9,]+$'),
                #ルール４：dictのキーは必須である。
                },required=True)

schema({
	'name':'ぶどう',
	'price':'3,000',
})

schema({
	'name':'test',
	'price':'A,000',
})