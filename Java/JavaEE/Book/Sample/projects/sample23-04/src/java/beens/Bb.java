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
    Employee3Db db;

    public List<Employee3> getAll() {
        return db.getAll();
    }

    @PostConstruct
    public void pc() {
        db.create(new Employee3("田中宏"));
        db.create(new Employee3("鈴木太郎"));
    }
}
