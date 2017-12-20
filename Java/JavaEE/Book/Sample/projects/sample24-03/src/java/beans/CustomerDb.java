package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerDb {

    @PersistenceContext
    private EntityManager em;

    public List<Information> getAll() {
        return em.createQuery("SELECT c FROM Information c").getResultList();
    }


    public void createCustomer(Customer customer) {
        em.persist(customer);
    }
}
