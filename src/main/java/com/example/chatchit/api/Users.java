package com.example.chatchit.api;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fbId")
    private String fbId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar")
    private String avatar;
}
