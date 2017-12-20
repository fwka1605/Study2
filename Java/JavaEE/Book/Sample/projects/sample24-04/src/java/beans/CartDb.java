package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CartDb {

    @PersistenceContext
    private EntityManager em;

    public List<Cart> getAll() {
        List<Cart> carts = em.createQuery("SELECT c FROM Cart c").getResultList();
        return carts;
    }

    public void createCart(Cart cart) {
        em.persist(cart);
    }
}
