package com.coffeehause.web.entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "employee")
public class Employee {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Long employee_id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;

    public Long getEmployee_id() {
        return employee_id;
    }
    @OneToMany(targetEntity = Event.class, mappedBy = "employee", fetch = FetchType.EAGER)
    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee {" + "id=" + this.employee_id + " name=" + this.name +
                " role=" + this.role + "}";
    }
}
