package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee3Db {

    @PersistenceContext
    private EntityManager em;

    public List<Employee3> getAll() {
        return em.createQuery("SELECT c FROM Employee3 c").getResultList();
    }

    public void create(Employee3 emp) {
        em.persist(emp);
    }
}
