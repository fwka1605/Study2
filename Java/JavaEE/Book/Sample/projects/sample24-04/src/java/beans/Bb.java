package beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    CartDb db;

    public List<Cart> getAll() {
        return db.getAll();
    }

    @PostConstruct
    private void init() {
        // カートを作る
        Cart cart1 = new Cart("田中宏");
        // 注文明細を作る
        OrderLine o1 = new OrderLine("ビール", 20, orderDate(2019, 0, 3));
        OrderLine o2 = new OrderLine("ワイン", 30, orderDate(2019, 0, 3));
        OrderLine o3 = new OrderLine("ウィスキー", 15, orderDate(2019, 0, 3));
        // カートに注文明細を登録する
        List<OrderLine> ls = cart1.getOrderLines();
        ls.add(o1);
        ls.add(o2);
        ls.add(o3);
        // データベースにカスケード保存
        create(cart1);

        // カートを作る
        Cart cart2 = new Cart("鈴木太郎");
        // 注文明細を作る
        OrderLine o4 = new OrderLine("ビール", 25, orderDate(2019, 0, 4));
        OrderLine o5 = new OrderLine("ウィスキー", 40, orderDate(2019, 0, 4));
        // カートに注文明細を登録する
        ls = cart2.getOrderLines();
        ls.add(o4);
        ls.add(o5);
        // データベースにカスケード保存
        create(cart2);
    }

    public void create(Cart c) {
        try {
            db.createCart(c);
        } catch (Exception e) {
        }
    }

    public Date orderDate(int y, int m, int d) {
        Calendar c = new GregorianCalendar(y, m, d);
        return c.getTime();
    }
}
