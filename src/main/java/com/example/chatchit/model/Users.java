package com.example.chatchit.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
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

    @Column(name = "status")
    private int status;

    @Column(name = "connectId")
    private String connectId;

    @Column(name = "queue")
    private int queue;

    @Column(name = "blocked")
    private int blocked;
}
