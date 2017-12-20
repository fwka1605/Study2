package beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BD_CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartID;
    private String customer;
    @OneToMany(mappedBy = "cart", cascade = {CascadeType.ALL})
    private List<OrderLine> orderLines = new ArrayList();

    // コンストラクタ
    public Cart() {
    }

    public Cart(String customerId) {
        this.customer = customerId;
    }

    public Cart(String customerId, List<OrderLine> orderLine) {
        this.customer = customerId;
        this.orderLines = orderLine;
    }

    // アクセサメソッド
    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    private static class cascade {

        public cascade() {
        }
    }

}
