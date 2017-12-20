package beens;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named
@ViewScoped
public class Bb implements Serializable {

    @EJB
    Employee2Db db;

    public List<Employee2> getAll() {
        return db.getAll();
    }

    @PostConstruct
    public void pc() {
        db.create(new Employee2(100L, "田中宏", new Tel("123-123", "092-111")));
        db.create(new Employee2(110L, "鈴木太郎", new Tel("321-332", "090-222")));
    }
}
