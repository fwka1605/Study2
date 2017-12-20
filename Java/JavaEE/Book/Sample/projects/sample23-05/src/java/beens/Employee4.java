package beens;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee4 implements Serializable {

    @EmbeddedId
    private CompositeKey id;
    private String name;

    public Employee4() {
    }

    public Employee4(CompositeKey id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompositeKey getId() {
        return id;
    }

    public void setId(CompositeKey id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
