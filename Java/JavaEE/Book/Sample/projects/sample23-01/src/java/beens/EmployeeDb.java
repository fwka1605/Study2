package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDb {

    @PersistenceContext
    private EntityManager em;

    // 登録
    public void create(Employee emp) {
        em.persist(emp);
    }

    // 全データをListにして取得
    public List<Employee> getAll() {
        return em.createQuery("SELECT c FROM Employee c").getResultList();
    }
}
