package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee5Db {

    @PersistenceContext
    private EntityManager em;

    public void create(Employee5 emp) {
        em.persist(emp);
    }

    public List<Employee5> getAll() {
        return em.createQuery("SELECT c FROM Employee5 c").getResultList();
    }
}
