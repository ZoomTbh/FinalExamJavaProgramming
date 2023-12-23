
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Studios implements Serializable{
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   private Integer studioId;
   @Column(name= "studio_name")
   private String studioName;
   @Column(name= "founded_date")
   private Date foundedDate;
   @Column(name="employees")
   private String employees;
   @ManyToOne
   @JoinColumn(name="business_id")
   private BusinessUnits business;
   @ManyToMany(mappedBy = "studios")
   private Set<Games> games = new HashSet<>();
   @ManyToOne
   @JoinColumn(name="licence_id")
   private Licence licence;

    public Studios() {
    }

    public Studios(Integer studioId) {
        this.studioId = studioId;
    }

    public Studios(Integer studioId, String studioName, Date foundedDate, String employees, BusinessUnits business, Licence licence) {
        this.studioId = studioId;
        this.studioName = studioName;
        this.foundedDate = foundedDate;
        this.employees = employees;
        this.business = business;
        this.licence = licence;
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

    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    
}
