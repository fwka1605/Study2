package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommuteDb {

    @PersistenceContext
    private EntityManager em;

    public void create(Commute commute) {
        em.persist(commute);
    }

    public void update(Commute commute) {
        em.merge(commute);
    }

    public void delete(Commute commute) {
        em.remove(em.merge(commute));  // mergしてから削除する
    }

    public Commute find(Transportation key) {
        return em.find(Commute.class, key);
    }

    public List<Commute> getAll() {
        return em.createQuery("SELECT c FROM Commute c").getResultList();
    }
}
