package beens;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "EMP")
public class Employee implements Serializable {

    @Id
    @NotNull
    private String id;
    private String eval;
    private String name;

    public Employee() {
    }

    public Employee(String id, String eval, String name) {
        this.id = id;
        this.eval = eval;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
