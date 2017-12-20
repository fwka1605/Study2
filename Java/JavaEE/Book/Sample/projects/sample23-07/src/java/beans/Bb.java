package beans;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import util.BinFileUtil;

@Named
@SessionScoped
public class Bb implements Serializable {

    @EJB
    Employee6Db db;

    public StreamedContent getPic() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("empId");
            Employee6 e = db.find(Integer.valueOf(key));
            ByteArrayInputStream in = new ByteArrayInputStream(e.getPicture());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }

    @PostConstruct
    public void pc() {

        byte[] dt = BinFileUtil.getBinary("/resources/images/pic-1.jpg");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 1);
        Date date = cal.getTime();
        Employee6 tanaka = new Employee6(1, "田中宏", dt, GroupColor.BLUE, date, date, cal);
        create(tanaka);
        //

        byte[] dt2 = BinFileUtil.getBinary("/resources/images/pic-2.jpg");
        cal = Calendar.getInstance();
        cal.set(2010, 2, 2);
        date = cal.getTime();
        Employee6 suzuki = new Employee6(2, "鈴木一郎", dt2, GroupColor.GREEN, date, date, cal);
        create(suzuki);
    }

    public void create(Employee6 e) {
        try {
            db.create(e);
        } catch (Exception ex) {
        }
    }

    public List<Employee6> getAll() {
        return db.getAll();
    }

}
