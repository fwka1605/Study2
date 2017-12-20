package beens;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee2 implements Serializable {

    @Id
    private Long id;
    private String name;
    @Embedded
    private Tel tel;

    public Employee2() {
    }

    public Employee2(Long id, String name, Tel tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tel getTel() {
        return tel;
    }

    public void setTel(Tel tel) {
        this.tel = tel;
    }

    public String getTelephone() {
        return tel.getTelephone();
    }

    public void setTelephone(String telephone) {
        tel.setTelephone(telephone);
    }

    public String getCellular() {
        return tel.getCellular();
    }

    public void setCellular(String cellular) {
        tel.setCellular(cellular);
    }
}
