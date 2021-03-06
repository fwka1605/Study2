package beens;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

@Entity
public class Employee8 implements Serializable {

    @Id
    private Long id;
    private String name;
    @ElementCollection
    @CollectionTable(name = "items")
    @MapKeyColumn(name = "drink")
    @Column(name = "num")
    private Map<String, Integer> items;

    public Employee8() {
    }

    public Employee8(Long id, String name, Map<String, Integer> items) {
        this.id = id;
        this.name = name;
        this.items = items;
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

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
}
