
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.annotation.Generated;




    public class Games implements Serializable{
    public static final long serialVersionUID = -4280788229663423228L;
    private Integer gameId;
    
    private String gameName;
   
    private Date publishingDate;
    
    private String type;
    
  
    
   private Studios studios;
   
    private Licence licence;

    public Games() {
    }

    public Games(Integer gameId) {
        this.gameId = gameId;
    }

    public Games(Integer gameId, String gameName, Date publishingDate, String type, Studios studios, Licence licence) {
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

    public Studios getStudios() {
        return studios;
    }

    public void setStudios(Studios studios) {
        this.studios = studios;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

   

    @Override
    public String toString() {
        return gameName;
    }

    
    
}
