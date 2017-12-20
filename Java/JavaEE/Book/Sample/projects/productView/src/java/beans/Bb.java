package beans;

import entity.*;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb extends SuperBb implements Serializable {

    public List<Product> getAll() {
        if (!flag) {
            return productDb.getAll();
        } else {
            return ls;
        }
    }

    public String jpql() {
        try {
            ls = jpql.do_JPQL(s);
            if (ls.size() == 0) {
                facesMessage("該当するエンティティはありません");
            } else {
                flag = true;
            }
        } catch (Exception e) {
            facesMessage("JPQLに誤りがあります");
        }
        return null;
    }

    public void cls() {
        s = null;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}
