package beens;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    Employee1Db db;

    public List<Employee1> getAll() {
        return db.getAll();
    }

    @PostConstruct
    public void pc() {
        db.create(new Employee1("100", "", "", "田中宏"));
        db.create(new Employee1("110", "大阪", "A", "鈴木太郎"));
    }
}
