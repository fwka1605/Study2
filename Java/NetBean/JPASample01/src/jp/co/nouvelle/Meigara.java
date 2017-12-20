/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author NVLCLT13
 */

@Entity
@Table(name="MEIGARA")
public class Meigara implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id = 0;
    
    @Column(name = "NAME")
    private String name="";
    
    @Column(name = "NAMEKANA")
    private String nameKana="";

    @Column(name = "DOSU")
    private int dosu=0;

    @Column(name = "KOJI")
    private String koji="";

    @Column(name = "SWEETPOTATONAME")
    private String sweetPotatoName="";

    @Column(name = "MANUFACTURER")
    private String manufacturer="";

    @Column(name = "VOLUME")
    private float volume=0;

    @Column(name = "PRICE")
    private int price=0;
        
    public Meigara() {
    }

    public Meigara(
        String name,
        String nameKana,
        int dosu,
        String koji,
        String sweetPotatoName,
        String manufacturer,
        float volume,
        int price
    ) {
        this.name = name;
        this.nameKana = nameKana;
        this.dosu = dosu;
        this.koji = koji;
        this.sweetPotatoName = sweetPotatoName;
        this.manufacturer = manufacturer;
        this.volume = volume;
        this.price = price;            
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKana() {
        return nameKana;
    }

    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }
    
    public int getDosu() {
        return dosu;
    }

    public void setDosu(int dosu) {
        this.dosu = dosu;
    }    

    public String getKoji() {
        return koji;
    }

    public void setKoji(String koji) {
        this.koji = koji;
    }

    public String getSweetPotatoName() {
        return sweetPotatoName;
    }

    public void setSweetPotatoName(String sweetPotatoName) {
        this.sweetPotatoName = sweetPotatoName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    
    
}
