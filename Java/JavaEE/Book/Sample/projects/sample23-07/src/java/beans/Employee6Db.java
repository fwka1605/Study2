package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Employee6Db {

    @PersistenceContext
    private EntityManager em;

    public void create(Employee6 meibo) {
        em.persist(meibo);
    }

    public Employee6 find(Integer key) {
        return em.find(Employee6.class, key);
    }

    public List<Employee6> getAll() {
        return em.createQuery("SELECT c FROM Employee6 c").getResultList();
    }
}
