package beans;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class WeatherNews {

    @EJB
    WeatherFeed feed;
    @Inject
    Event<String> event;

    @Schedule(hour = "*/6", persistent = false)
    public void send() {
        String s = feed.rss(42);
        event.fire(s);
        System.out.println("★タイマー実行");
    }
}
