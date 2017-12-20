package beans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

@RequestScoped
public class ReaderB {

    @EJB
    MailSender sender;

    // 実際にメールを送信するにはGoogle mailのid, password, メールアドレスを記入してください。
    public void read(@Observes String feed) {
        sender.send("あなたのメールアドレス", "天気予報Ｂ", feed);
    }
}
