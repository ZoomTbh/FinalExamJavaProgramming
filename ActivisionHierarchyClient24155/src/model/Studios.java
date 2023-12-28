
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Studios implements Serializable{
  public static final long serialVersionUID = -5829355281680999861L;
   private Integer studioId;
 
   private String studioName;
  
   private Date foundedDate;
  
   private String employees;
   
   private BusinessUnits business;
   
   private List<Games> games = new ArrayList<>();
  
   private List<Licence>licence = new ArrayList<>();

    public Studios() {
    }

    public Studios(Integer studioId) {
        this.studioId = studioId;
    }

    public Studios(Integer studioId, String studioName, Date foundedDate, String employees, BusinessUnits business) {
        this.studioId = studioId;
        this.studioName = studioName;
        this.foundedDate = foundedDate;
        this.employees = employees;
        this.business = business;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Date foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public BusinessUnits getBusiness() {
        return business;
    }

    public void setBusiness(BusinessUnits business) {
        this.business = business;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    public List<Licence> getLicence() {
        return licence;
    }

    public void setLicence(List<Licence> licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return studioName;
    }

    
}
