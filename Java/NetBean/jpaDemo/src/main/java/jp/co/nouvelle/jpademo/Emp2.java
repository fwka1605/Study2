/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.jpademo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author NVLCLT13
 */
@Entity
@Table(name = "emp2")
@NamedQueries({
    @NamedQuery(name = "Emp2.findAll", query = "SELECT e FROM Emp2 e")})
public class Emp2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no")
    private String no;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Emp2() {
    }

    public Emp2(String no) {
        this.no = no;
    }

    public Emp2(String no, String name) {
        this.no = no;
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp2)) {
            return false;
        }
        Emp2 other = (Emp2) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.nouvelle.jpademo.Emp2[ no=" + no + " ]";
    }
    
}
