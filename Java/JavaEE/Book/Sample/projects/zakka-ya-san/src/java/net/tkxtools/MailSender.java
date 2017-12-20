
package net.tkxtools;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;


@Stateless
public class MailSender {
	
        String	mail_id = "あなたのメールID";
	String	mail_pw = "あなたのメールパスワード";
	String	from    = "あなたのメールアドレス";

	String	host =	"smtp.gmail.com";
	int	port =	587;
	public	MailSender(){}	
	@Asynchronous
	public	void send(String c_mail, String subject, String body){
		try {
			JmSender.send(mail_id, mail_pw, host, port,c_mail, from, subject, body);
		} catch (Exception e) {}
	}
}
