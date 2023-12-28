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


/**
 *
 * @author royon
 */

public class Company implements Serializable{
  public static final long serialVersionUID = 2003383627637874305L;
  private Integer id;
   
   private String compName;
   
   private String compIndustry;
  
   private String lei;
  
   private Date foundedDate;
  
  private byte[] image;
 
   private List<BusinessUnits> business = new ArrayList<>();
   
   
    private Director director;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(Integer id, String compName, String compIndustry, String lei, Date foundedDate, byte[] image, Director director) {
        this.id = id;
        this.compName = compName;
        this.compIndustry = compIndustry;
        this.lei = lei;
        this.foundedDate = foundedDate;
        this.image = image;
        this.director = director;
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return compName;
    }
    
    
  
    
}
