package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee2Db {

    @PersistenceContext
    private EntityManager em;

    public List<Employee2> getAll() {
        return em.createQuery("SELECT c FROM Employee2 c").getResultList();
    }

    public void create(Employee2 emp) {
        em.persist(emp);
    }
}
