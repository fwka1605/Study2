import sys


sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib64/python3.5/site-packages')
sys.path.append('/usr/local/lib/python3.5/site-packages')
sys.path.append('/usr/local/lib/python2.7/site-packages')
sys.path.append('/usr/lib/python2.7/dist-packages')

from retrying import retry
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

#stop_max_attempt_numberは最大リトライ回数を指定する
#wait_exponential_multiplierは指数関数的なウェイトを取る場合の、
# 初回のウェイトをミリ秒単位で指定する。
@retry(stop_max_attempt_number=3,wait_exponential_multiplier=1000)
def fetch(url):
	"""
	指定したURLを取得してResponseオブジェクトを返す
	一時的なエラーが起きた場合は最大3回リトライする。
	"""

	print('Retrieving{0}...'.format(url))
	response=requests.get(url)
	print('Status:{0}'.format(response.status_code))
	
	if response.status_code not in TEMPORARY_ERROR_CODES:
		return response
	else:
		raise Exception('Temporary Error:{0}'.format(response.status_code))


if __name__ == '__main__':
	main()