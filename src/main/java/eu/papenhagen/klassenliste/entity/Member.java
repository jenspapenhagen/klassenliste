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
 * Member Class
 *
 * @author jay
 */
@AllArgsConstructor
@Entity
@Table(name = "member")
@NamedQueries({
    @NamedQuery(name = "Member.findByGender",
            query = "SELECT m FROM member m INNER JOIN m.country_id cc where m.gender=:gender")
    ,
    @NamedQuery(name = "Member.findByAge",
            query = "SELECT m FROM member m INNER JOIN m.country_id cc where m.age=:age")
    ,
        @NamedQuery(name = "Member.findByCountry",
            query = "SELECT m FROM member m INNER JOIN m.country_id cc where m.country=:country")
})

//SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "nachname")
    private String nachname;

    @Getter
    @Setter
    @Column(name = "gender")
    private boolean gender;

    @Getter
    @Setter
    @Column(name = "age")
    private int age;

    @Getter
    @Setter
    @Column(name = "bemerkung")
    private String bemerkung;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name=" + name + ", nachname=" + nachname + ", gender=" + gender + ", age=" + age + ", bemerkung=" + bemerkung + ", country=" + country.getCountryname() + '}';
    }

}
