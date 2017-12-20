package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Employee6 implements Serializable {

    @Id
    @Column(name = "e_id", nullable = false)
    private Integer id;
    @Column(name = "m_name", nullable = false)
    private String name;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;		// 画像などの大きなデータ
    @Enumerated(EnumType.STRING)
    private GroupColor color;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.DATE)
    private Calendar birthday;
    @Transient
    private int interval;

    public Employee6() {
    }

    public Employee6(
            Integer id,
            String name,
            byte[] picture,
            GroupColor color,
            Date dateTime,
            Date startTime,
            Calendar birthday) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.color = color;
        this.dateTime = dateTime;
        this.startTime = startTime;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public GroupColor getColor() {
        return color;
    }

    public void setColor(GroupColor color) {
        this.color = color;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

}
