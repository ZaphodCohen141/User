package com.User.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("age")
    private Double age;
    @JsonProperty("address")
    private String address;
    @JsonProperty("join_date")
    private Date date;

    public User() {
    }

    public User(Integer userId, String firstName, String lastName, String email, Double age, String address, Date date) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
        this.date = date;
    }

    public User(Integer id, String firstName, String lastName, String email, Double age, java.sql.Date joinDate) {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
