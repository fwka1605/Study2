package beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@RequestScoped
public class ReaderA {
    @Inject
    transient Logger log;

    public void read(@Observes String feed) {
        log.fine("イベント受領Ａ");
        log.fine(feed);
    }
}
