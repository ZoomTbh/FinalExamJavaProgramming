
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Director implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer directorId;
    @Column(name="director_name")
    private String dirName;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "contact")
    private String contact;
    @OneToOne (mappedBy = "director")
    private Company company;

    public Director() {
    }

    public Director(Integer directorId) {
        this.directorId = directorId;
    }

    public Director(Integer directorId, String dirName, Date dob, String contact, Company company) {
        this.directorId = directorId;
        this.dirName = dirName;
        this.dob = dob;
        this.contact = contact;
        this.company = company;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
    
}
