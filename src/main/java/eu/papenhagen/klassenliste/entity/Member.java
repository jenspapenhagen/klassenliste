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
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nachname")
    private String nachname;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "age")
    private int age;
    
    @Column(name = "bemerkung")
    private String bemerkung;
    

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name=" + name + ", nachname=" + nachname + ", gender=" + gender + ", age=" + age + '}';
    }

}
