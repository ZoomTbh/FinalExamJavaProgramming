
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Games implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer gameId;
    @Column(name="game_name")
    private String gameName;
    @Column(name="publishingDate")
    private Date publishingDate;
    @Column(name="game_type")
    private String type;
    @ManyToMany
    @JoinTable(
            name="game_studios",
            joinColumns = @JoinColumn(name="game_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id")
    )
    
    private Set<Studios> studios;
    @ManyToOne
    @JoinColumn(name= "licence_id")
    private Licence licence;

    public Games() {
    }

    public Games(Integer gameId) {
        this.gameId = gameId;
    }

    public Games(Integer gameId, String gameName, Date publishingDate, String type, Set<Studios> studios, Licence licence) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.publishingDate = publishingDate;
        this.type = type;
        this.studios = studios;
        this.licence = licence;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Studios> getStudios() {
        return studios;
    }

    public void setStudios(Set<Studios> studios) {
        this.studios = studios;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    
}
