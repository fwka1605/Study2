/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NVLCLT13
 */
@Stateless
public class BookDb {
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(Book book){
        em.persist(book);
    }

    public void update(Book book){
        em.merge(book);
    }
    
    public Book find(Object code){
        return em.find(Book.class, code);
    }
}
