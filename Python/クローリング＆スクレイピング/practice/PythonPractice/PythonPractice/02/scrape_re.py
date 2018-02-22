import re 
from html import unescape

with open('db.html') as f:
    html = f.read()

for partial_html in re.findall(r'<a itemprop="url".*?</ul>\s*</a></li>',html,re.DOTALL):
    match = re.search(r'<a itemprop="url" href="(.*?)">', partial_html)
    url = match.group(1)
    url = 'https://gihyo.jp' + url

    match = re.search(r'<p itemprop="name".*?</p>', partial_html)
    title = match.group(0)

    title = title. replace('<br/>', '')
    title = re.sub( r'<.*?>', '', title) 
    title = unescape( title) 
    print( url, title)






