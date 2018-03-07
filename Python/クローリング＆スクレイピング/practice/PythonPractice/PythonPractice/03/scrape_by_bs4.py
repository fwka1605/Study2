import sys

sys.path.append('/usr/lib64/python3.5/site-packages')
sys.path.append('/usr/lib/python3.5/site-packages')

from bs4 import BeautifulSoup

with open('index.html') as f:
	soup = BeautifulSoup(f,'html.parser')
	
for a in soup.find_all('a'):
	print(a.get('href'),a.text)
	