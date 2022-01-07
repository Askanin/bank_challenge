package com.bankchallenge.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIO")
@Data
public class User {

    @Id
    @GeneratedValue (generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private String name;
    private String email;
    private String password;
//    @OneToMany
//    private List<Phone> phones;

}
