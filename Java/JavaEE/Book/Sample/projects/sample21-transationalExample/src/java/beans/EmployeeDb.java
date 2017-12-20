package beans;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional
public class EmployeeDb {

    @PersistenceContext
    private EntityManager em;

    public void create(Employee employee) {
        em.persist(employee);
    }

    public Employee update(Employee employee) {
        return em.merge(employee);
    }

    public Employee find(Object number) {
        return em.find(Employee.class, number);
    }
}
