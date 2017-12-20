package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDb {

    @PersistenceContext
    private EntityManager em;

    public void create(Employee employee) {
        em.persist(employee);
    }
}
