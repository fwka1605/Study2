package beans;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Employee implements Serializable {

    @Id
    private Integer number;		// 番号
    private String name;		// 氏名
    private String mail;		// メール

    public Employee() {
    }

    public Employee(Integer number, String name, String mail) {
        this.number = number;
        this.name = name;
        this.mail = mail;
    }

    // セッターとゲッター

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
