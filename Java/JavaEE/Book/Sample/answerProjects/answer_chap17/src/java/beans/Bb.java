package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    CommuteDb db;

    public String init() {

        Commute c = new Commute(Transportation.BUS, 15000, null);
        Employee e1 = new Employee("田中宏", c);
        Employee e2 = new Employee("鈴木一郎", c);
        List<Employee> ls = new ArrayList<>();
        ls.add(e1);
        ls.add(e2);
        c.setEmployees(ls);
        create(c);

        c = new Commute(Transportation.TRAM, 10000, null);
        Employee e3 = new Employee("山田花子", c);
        Employee e4 = new Employee("中村太郎", c);
        ls.clear();
        ls.add(e3);
        ls.add(e4);
        c.setEmployees(ls);
        create(c);

        c = new Commute(Transportation.CAR, 12000, null);
        Employee e5 = new Employee("佐藤修", c);
        ls.clear();
        ls.add(e5);
        c.setEmployees(ls);
        create(c);  
        
        return "output";

    }

    public List<Commute> getAllCommute() {
        return db.getAll();
    }

    public void create(Commute c) {
        try {
            db.create(c);
        } catch (Exception e) {
        }
    }

}
