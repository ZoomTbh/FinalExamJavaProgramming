
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BusinessUnits implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "businessID")
    private Integer businessID;
    @Column(name = "businessName")
    private String bussinessName;
    @Column(name = "founded_date")
    private Date foundedDate;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    @OneToMany
    private List<Studios> studios = new ArrayList<>();

    public BusinessUnits() {
    }

    public BusinessUnits(Integer businessID) {
        this.businessID = businessID;
    }

    public BusinessUnits(Integer businessID, String bussinessName, Date foundedDate, Company company) {
        this.businessID = businessID;
        this.bussinessName = bussinessName;
        this.foundedDate = foundedDate;
        this.company = company;
    }

    public Integer getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Integer businessID) {
        this.businessID = businessID;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Date foundedDate) {
        this.foundedDate = foundedDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Studios> getStudios() {
        return studios;
    }

    public void setStudios(List<Studios> studios) {
        this.studios = studios;
    }
    
    
}
