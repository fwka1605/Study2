package beens;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    Employee8Db db;

    public List<Employee8> getAll() {
        return db.getAll();
    }

    @PostConstruct
    private void pc() {
        Map<String, Integer> map = new LinkedHashMap();
        map.put("ビール", 10);
        map.put("ウィスキー", 11);
        Employee8 emp1 = new Employee8(1L, "田中宏", map);
        create(emp1);

        Employee8 emp2 = new Employee8(2L, "中村太郎", map);
        create(emp2);
    }

    public void create(Employee8 emp) {
        try {
            db.create(emp);
        } catch (Exception e) {
        }
    }
}
