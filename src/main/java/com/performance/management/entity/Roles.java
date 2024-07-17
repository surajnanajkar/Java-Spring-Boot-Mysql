package com.performance.management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String roleDescription;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
