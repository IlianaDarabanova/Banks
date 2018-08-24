package com.example.subscribers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankID;

    @NotBlank
    @Column(unique=true)
    private String username;

    @NotBlank
    private String password;

    //Details
    private String description;

    @NotBlank
    @Column(unique=true)
    private String EIK;

    @OneToMany(mappedBy = "bank")
    @JsonIgnore
    List<Subscriber> subscribers;

    public Bank() {
    }

    public int getBankID() {

        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEIK() {
        return EIK;
    }

    public void setEIK(String EIK) {
        this.EIK = EIK;
    }


    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

}
