import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import feedparser

d=feedparser.parse('http://b.hatena.ne.jp/hotentry/it.rss')

for entry in d.entries:
	print(entry.link,entry.title)
