package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee4Db {

    @PersistenceContext
    private EntityManager em;

    public List<Employee4> getAll() {
        return em.createQuery("SELECT c FROM Employee4 c").getResultList();
    }

    public void create(Employee4 emp) {
        em.persist(emp);
    }
}
