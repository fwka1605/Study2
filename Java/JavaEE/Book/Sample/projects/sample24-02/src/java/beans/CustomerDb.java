package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerDb {

    @PersistenceContext
    private EntityManager em;

    public List<Customer> getAll() {
        return em.createQuery("SELECT c FROM Customer c").getResultList();
    }

    public void createCustomer(Customer customer) {
        em.persist(customer);
    }
}
