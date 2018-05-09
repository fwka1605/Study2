import sys

import time

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')

import requests

#一時的なエラーを表すすてーたさうコード
TEMPORARY_ERROR_CODES=(408,500,502,503,504)


def main():
	"""
	メイン
	"""
	response=fetch('http://httpbin.org/status/200,404,503')
	
	if 200 <= response.status_code <300:
		print('Success!')
	else:
		print('Error!')

def fetch(url):
	"""
	指定したURLを取得してResponseオブジェクトを返す。
	一時的なエラーが起きた場合は最大３回リトライをする
	"""
	#最大リトライ回数
	max_retries=3
	
	#現在のリトライ回数
	retries=0
	
	while True:
		try:
			print('Retrieving{0}...'.format(url))
			response=requests.get(url)
			print('Status:{0}'.format(response.status_code))
	
			if response.status_code not in TEMPORARY_ERROR_CODES:
				return response

		except requests.exceptoins.RequestException as ex:
			print('Exception occured: {0}'.format(ex))
	
		retries +=1
	
		if retries >= max_retries:
			raise Exception('Too many retries.')
			
		wait = 2**(retries-1)
		
		print('Waiting {0} seconds...'.format(wait))
		time.sleep(wait)


if __name__ == '__main__':
	main()