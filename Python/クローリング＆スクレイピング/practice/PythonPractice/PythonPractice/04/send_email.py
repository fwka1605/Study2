import smtplib
from email.mime.text import MIMEText
from email.header import Header

msg = MIMEText('メールの本文です。')
msg['Subject'] = Header('メールの件名','utf-8')
msg['From'] = 'fwka1605.dnou@gmail.com'
msg['To'] = 'maruyama@d-nuo.co.jp'

with smtplib.SMTP('smtp.gmail.com',587) as smtp:
	smtp.ehlo()
	smtp.starttls()
	smtp.login('fwka1605.dnou@gmail.com','mam6mck3')
	smtp.send_message(msg)
