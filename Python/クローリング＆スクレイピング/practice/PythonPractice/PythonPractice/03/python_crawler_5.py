import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import re

import requests
import lxml.html

def main():
	"""
		クローラーのメイン処理
	"""
	session = requests.Session();
	response=session.get('https://gihyo.jp/dp')
	
	urls = scrape_list_page(response)
	
	for url in urls:
		response=session.get(url)
		ebook=scrape_detail_page(response)
		print(ebook)
		break
	
def scrape_list_page(response):

	root=lxml.html.fromstring(response.content)
	#すべてのリンクを絶対URLに変換する
	root.make_links_absolute(response.url)

	for a in root.cssselect('#listBook a[itemprop="url"]'):
		url = a.get('href')
		yield url
		
def scrape_detail_page(response):

	root = lxml.html.fromstring(response.content)
	
	ebook = {
		'url':response.url,
		'title':root.cssselect('#bookTitle')[0].text_content(),
		'price':root.cssselect('.buy')[0].text.strip(),
		'content':[normalize_spaces(h3.text_content()) for h3 in root.cssselect('#content > h3')],
	}
	return ebook

def normalize_spaces(s):
	
	return re.sub(r'\s+', ' ', s).strip()


if __name__ == '__main__':
	main()

