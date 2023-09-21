package com.coffeehause.web.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stage")
public class Stage {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stage_id")
    Long stage_id;
    @Column(name = "stage_name")
    private String name;

    public Long getStage_id() {
        return stage_id;
    }

    @OneToMany(mappedBy = "stage", fetch = FetchType.EAGER)
    public String getName() {
        return name;
    }

//    @OneToMany(targetEntity = Event.class, mappedBy = "stage", fetch = FetchType.EAGER)
//    public String getname() {
//        return name;
//    }

    @Override
    public String toString() {
        return "Stage {" + "id=" + this.stage_id + " name=" + this.name + "}";
    }
}
