package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {

    @Id
    private String customerId;
    private String name;
    private Information info;

    // コンストラクタ
    public Customer() {
    }

    public Customer(String customerId, String name, Information info) {
        this.customerId = customerId;
        this.name = name;
        this.info = info;
    }

    // アクセサメソッド
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Information getInfo() {
        return info;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

}
