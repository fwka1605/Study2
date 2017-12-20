package beens;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee8Db {

    @PersistenceContext
    private EntityManager em;

    public List<Employee8> getAll() {
        return em.createQuery("SELECT c FROM Employee8 c").getResultList();
    }

    public void create(Employee8 emp) {
        em.persist(emp);
    }
}
