/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.entity;

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
public class Member {

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

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name=" + name + ", nachname=" + nachname + ", gender=" + gender + ", age=" + age + '}';
    }

}
