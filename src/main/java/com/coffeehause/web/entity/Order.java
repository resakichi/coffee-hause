package com.coffeehause.web.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "orders")
public class Order {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long order_id;
    @Column(name = "create_time")
    private Time create_time;
    @ManyToOne
    @JoinColumn(name = "stage")
    private Stage stage;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client_id;

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    @OneToMany(targetEntity = Event.class, mappedBy = "orders", fetch = FetchType.EAGER)
    public Long getOrder_id() {
        return order_id;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Time getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Time create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Event {" + "id=" + this.order_id + " create_time=" + this.create_time +
                " stage=" + this.stage + " client=" + this.client_id + "}";
    }
}
