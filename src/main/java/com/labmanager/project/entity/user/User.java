package com.labmanager.project.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labmanager.project.entity.member.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column( name = "email")
    private String email;

    public User(String email, String password, Member member) {
        this.email = email;
        this.password = password;
        this.member = member;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "password")
    private String password;

    @OneToOne( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Member member;


    public User(String email) {
        this.email = email;
    }

    public User() {}

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "UserEntity{}";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setId(int id) {
        this.id = id;
    }

}









