package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commute implements Serializable {

    @Id
    @Enumerated(EnumType.STRING)
    private Transportation tid;
    private Integer allowance;
    @OneToMany(mappedBy = "commute", cascade = {CascadeType.ALL})
    private List<Employee> employees;

    // コンストラクタ
    public Commute() {
    }

    public Commute(Transportation tid, Integer allowance, List<Employee> employees) {
        this.tid = tid;
        this.allowance = allowance;
        this.employees = employees;
    }

    // アクセサメソッド
    public Transportation getTid() {
        return tid;
    }

    public void setTid(Transportation tid) {
        this.tid = tid;
    }

    public Integer getAllowance() {
        return allowance;
    }

    public void setAllowance(Integer allowance) {
        this.allowance = allowance;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
