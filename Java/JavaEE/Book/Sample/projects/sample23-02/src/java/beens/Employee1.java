package beens;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity
@SecondaryTables({
    @SecondaryTable(name = "ADDRESS"),
    @SecondaryTable(name = "SKILL")
})
public class Employee1 implements Serializable {

    @Id
    private String id;
    @Column(table = "ADDRESS")
    private String city;
    @Column(table = "SKILL")
    private String eval;
    private String name;

    public Employee1() {
    }

    public Employee1(String id, String city, String eval, String name) {
        this.id = id;
        this.city = city;
        this.eval = eval;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
