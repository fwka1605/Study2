package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee7Db {

    @PersistenceContext
    private EntityManager em;

    public List<Employee7> getAll() {
        return em.createQuery("SELECT c FROM Employee7 c").getResultList();
    }

    public void create(Employee7 emp) {
        em.persist(emp);
    }
}
