package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee1Db {

    @PersistenceContext
    private EntityManager em;

    public List<Employee1> getAll() {
        return em.createQuery("SELECT c FROM Employee1 c").getResultList();
    }

    public void create(Employee1 emp) {
        em.persist(emp);
    }
}
