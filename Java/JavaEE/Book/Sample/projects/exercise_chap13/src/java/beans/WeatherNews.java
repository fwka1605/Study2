package beans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class WeatherNews {
    @EJB
    WeatherFeed weatherFeed;
    
    @EJB
    MailSender mailSender;

	// タイマーサービスを使って指定時間にメールを出すための@Scheduleアノテーションを追加する
    public void send() { // 自分あてに天気情報を送信する処理
        // ここにメール送信処理を書く

    }
}
