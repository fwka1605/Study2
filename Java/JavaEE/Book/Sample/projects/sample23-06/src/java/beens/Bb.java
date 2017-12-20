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
    Employee5Db db;

    public List<Employee5> getAll() {
        return db.getAll();
    }

    @PostConstruct
    public void pc() {
        db.create(new Employee5("A10", "100", "田中宏"));
        db.create(new Employee5("A20", "200", "鈴木太郎"));
    }
}
