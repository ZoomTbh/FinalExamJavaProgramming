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
import java.util.Set;
import javax.persistence.*;

@Entity
public class Licence implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="licence_name")
    private String licence_name;
    @Column(name="creation_name")
    private Date creation_date;
    @OneToMany
    @JoinColumn(name="studios_id")
   private List<Studios> studios = new ArrayList<>();
    @OneToMany(mappedBy = "licence")
    private List<Games> games = new ArrayList<>();

    public Licence() {
    }

    public Licence(Integer id) {
        this.id = id;
    }

    public Licence(Integer id, String licence_name, Date creation_date) {
        this.id = id;
        this.licence_name = licence_name;
        this.creation_date = creation_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicence_name() {
        return licence_name;
    }

    public void setLicence_name(String licence_name) {
        this.licence_name = licence_name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public List<Studios> getStudios() {
        return studios;
    }

    public void setStudios(List<Studios> studios) {
        this.studios = studios;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    
}
