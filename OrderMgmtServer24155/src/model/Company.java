/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author royon
 */
@Entity
public class Company implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(name="compName")
   private String compName;
   @Column(name="compIndustry")
   private String compIndustry;
   @Column(name="lei_number")
   private String lei;
   @Column(name="founded_date")
   private Date foundedDate;
   @Column(name= "logo")
   private byte[] image;
   @OneToMany(mappedBy = "company")
   private List<BusinessUnits> business = new ArrayList<>();
   @OneToOne
   @JoinColumn(name="director_id")
   private Director director;
   
   
   public Company(){
       
   }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(Integer id, String compName, String compIndustry, String lei, Date foundedDate, byte[] image) {
        this.id = id;
        this.compName = compName;
        this.compIndustry = compIndustry;
        this.lei = lei;
        this.foundedDate = foundedDate;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompIndustry() {
        return compIndustry;
    }

    public void setCompIndustry(String compIndustry) {
        this.compIndustry = compIndustry;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Date foundedDate) {
        this.foundedDate = foundedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<BusinessUnits> getBusiness() {
        return business;
    }

    public void setBusiness(List<BusinessUnits> business) {
        this.business = business;
    }

  

    
}
