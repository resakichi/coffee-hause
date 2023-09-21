package com.coffeehause.web.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    Long client_id;
    @Column(name = "client_name")
    private String name;
    public Long getClient_id() {
        return client_id;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "client", fetch = FetchType.EAGER)
    public String getName() {
        return name;
    }
    @OneToMany(targetEntity = Event.class, mappedBy = "client", fetch = FetchType.EAGER)
    public String getNameEvent(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client {" + "id=" + this.client_id + " name=" + this.name + "}";
    }
}
