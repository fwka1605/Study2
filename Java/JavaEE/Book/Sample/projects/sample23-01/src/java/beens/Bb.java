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
    EmployeeDb db;

    public List<Employee> getAll() {
        return db.getAll();
    }

    @PostConstruct
    public void pc() {
        db.create(new Employee("100", "A", "田中宏"));
        db.create(new Employee("110", "A", "鈴木太郎"));
    }
}
