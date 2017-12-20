package beens;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    Employee7Db db;

    public List<Employee7> getAll() {
        return db.getAll();
    }

    @PostConstruct
    private void pc() {
        List<String> ls = new ArrayList<>();
        ls.add("5日15時：仕様書検討ミーティング");
        ls.add("12日13時：営業会議");
        Employee7 emp1 = new Employee7(1L, "田中宏", ls);
        create(emp1);

        ls.clear();
        ls.add("7日～12日：出張");
        ls.add("13日午後：打ち合わせ");
        Employee7 emp2 = new Employee7(2L, "鈴木一郎", ls);
        create(emp2);
    }

    public void create(Employee7 emp) {
        try {
            db.create(emp);
        } catch (Exception e) {
        }
    }
}
