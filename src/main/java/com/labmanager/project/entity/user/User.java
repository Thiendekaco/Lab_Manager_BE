package com.labmanager.project.entity.user;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column( name = "email")
    private String emailUser;



    public User(String emailUser, int ageUser) {

        this.emailUser = emailUser;
    }

    public User(String emailUser) {
        this.emailUser = emailUser;
    }

    public User() {}

    @Override
    public String toString() {
        return "UserEntity{}";
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}









