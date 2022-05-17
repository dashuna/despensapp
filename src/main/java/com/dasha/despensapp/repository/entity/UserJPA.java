package com.dasha.despensapp.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserJPA {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String password;
    private String name;
    private String last_name;
    private String email;
    private String telephone;
    private byte[] photo;

    public UserJPA() {
    }

    public UserJPA(Long id, String user, String password, String name, String last_name, String email, String telephone, byte[] photo) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.telephone = telephone;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
