package com.coffeehause.web.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "role")
public class Role {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Long role_id;
    @Column(name = "name")
    private String name;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
    @OneToMany(targetEntity = Employee.class, mappedBy = "role", fetch = FetchType.EAGER)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role {" + "id=" + this.role_id + " name=" + this.name + "}";
    }
}
