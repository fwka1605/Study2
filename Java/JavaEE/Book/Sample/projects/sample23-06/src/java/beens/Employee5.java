package beens;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class Employee5 implements Serializable {

    @Id
    private String groupId;
    @Id
    private String userId;
    private String name;

    public Employee5() {
    }

    public Employee5(String groupId, String id, String name) {
        this.groupId = groupId;
        this.userId = id;
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee5{" + "groupId=" + groupId + ", userId=" + userId + ", name=" + name + '}';
    }

}
