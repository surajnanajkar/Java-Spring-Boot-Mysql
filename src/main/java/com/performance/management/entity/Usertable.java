package com.performance.management.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "usertable")
public class Usertable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String empId;

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private Timestamp createdatetime;

    private Integer roleFid;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Timestamp createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Integer getRoleFid() {
        return roleFid;
    }

    public void setRoleFid(Integer roleFid) {
        this.roleFid = roleFid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
