package beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    CustomerDb db;

    public List<Customer> getAll() {
        return db.getAll();
    }

    @PostConstruct
    private void pc() {
        //
        Information info1 = new Information("東京都", "03-333-3333", "090-333-3333");
        Information info2 = new Information("大阪府", "06-666-6666", "090-666-6666");
        Customer c1 = new Customer("cus001", "田中宏", info1);
        Customer c2 = new Customer("cus002", "鈴木太郎", info2);
        create(c1);
        create(c2);
    }

    public void create(Customer c) {
        try {
            db.createCustomer(c);
        } catch (Exception e) {
        }
    }
}
