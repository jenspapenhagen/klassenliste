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
 *
 * @author jay
 */
@AllArgsConstructor
@Entity(name = "Country")
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll",
            query = "from Country")
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
