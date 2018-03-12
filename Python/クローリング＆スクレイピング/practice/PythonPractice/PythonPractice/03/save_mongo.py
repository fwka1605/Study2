import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import lxml.html

from pymongo import MongoClient


tree=lxml.html.parse('index.html')
html=tree.getroot()

client=MongoClient('localhost',27017)

db=client.scraping

collection=db.links

collection.delete_many({})

for a in html.cssselect('a'):
	collection.insert_one({
		'url':a.get('href'),
		'title':a.text
	})
	
for link in collection.find().sort('_id'):
	print(link['_id'],link['url'],link['title'])
	
