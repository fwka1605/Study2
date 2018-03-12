import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import requests
import lxml.html

def main():
	"""
		クローラーのメイン処理
	"""
	response=requests.get('https://gihyo.jp/dp')
	
	urls = scrape_list_page(response)
	
	for url in urls:
		print(url)
	
def scrape_list_page(response):

	root=lxml.html.fromstring(response.content)
	#すべてのリンクを絶対URLに変換する
	root.make_links_absolute(response.url)

	for a in root.cssselect('#listBook a[itemprop="url"]'):
		url = a.get('href')
		yield url
		
if __name__ == '__main__':
	main()

