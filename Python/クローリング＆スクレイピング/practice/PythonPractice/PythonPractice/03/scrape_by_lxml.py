import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')

import lxml.html

tree = lxml.html.parse('index.html')

html = tree.getroot()

for a in html.cssselect('a'):
	print(a.get('href'),a.text)