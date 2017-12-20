package beans;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class WeatherNews {

    @EJB
    WeatherFeed feed;

    @EJB
    MailSender sender;

    // 必ずpersistent=falseを指定する
    // 以下では、実際のメールID、パスワード、メールアドレスをセットしてください。
    @Schedule(hour = "*/6", persistent = false)
    public void send() {
        sender.send("あなたのメールアドレス", "お天気情報", feed.rss(13));
    }
}
