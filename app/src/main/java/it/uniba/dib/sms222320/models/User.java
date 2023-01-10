package it.uniba.dib.sms222320.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.time.LocalDate;
import java.util.Date;

@IgnoreExtraProperties
public class User {

    private Role role;
    private String username;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String birthDate;
    private String city;
    private String address;
    private String telephone;

    public User(Role role, String username, String email, String password, String name, String surname, String birthDate, String city, String address, String telephone) {
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
    }

    public User() {
        //Do Nothing
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
