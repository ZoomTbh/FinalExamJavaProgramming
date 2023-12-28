
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BusinessUnits implements Serializable{
   public static final long serialVersionUID = -696077310579408160L;
    private Integer businessID;
    private String bussinessName;
    private Date foundedDate;

    private Company company;

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

    @Override
    public String toString() {
        return bussinessName;
    }
    
    
}
