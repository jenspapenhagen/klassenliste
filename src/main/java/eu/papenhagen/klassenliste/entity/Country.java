/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 * Country Class
 * @author jay
 */
@AllArgsConstructor
@Entity
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findByFirstLetter",
            query = "select co form Country co where co.countryname like :letter"),
     @NamedQuery(name = "Country.findByLastLetter",
            query = "select co form Country co where co.countryname like :letter")    
})
public class Country implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @Getter
    private int id;
    
    @Getter
    @Setter
    @Column(name = "countryname")
    private String countryname;

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" + "ID=" + id + ", countryname=" + countryname + '}';
    }
    

}
