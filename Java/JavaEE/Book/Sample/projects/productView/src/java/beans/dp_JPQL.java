/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class dp_JPQL {

    @PersistenceContext
    protected EntityManager em;

    public List<Product> do_JPQL(String s) {
        TypedQuery q = em.createQuery(s, Product.class);
        return q.getResultList();
    }
}
