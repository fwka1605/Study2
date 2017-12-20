package beans;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@RequestScoped
public class Bb {

    @NotNull
    private Integer number;
    @Size(max = 20, min = 1)
    private String name;
    @Size(max = 30, min = 1)
    private String mail;

    @EJB
    EmployeeDb db;
    @Inject
    transient Logger log;	// ログの記録用

    public String next() {
        create();		// 新規登録
        return null;		// 画面再表示
    }

    public void create() {
        Employee emp = new Employee(number, name, mail);// エンティティを生成
        try {
            db.create(emp);
            clear();
        } catch (Exception e) {
            log.severe("★新規登録できない/" + number);	// 失敗
        }
    }

    public void clear() {	// 表示用に変数をクリアする
        number = null;
        name = mail = null;
    }

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
