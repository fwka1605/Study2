package beens;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee7 implements Serializable {

    @Id
    private Long id;
    private String name;
    @ElementCollection
    @CollectionTable(name = "notes")
    private List<String> notes;

    public Employee7() {
    }

    public Employee7(Long id, String name, List<String> notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
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

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

}
