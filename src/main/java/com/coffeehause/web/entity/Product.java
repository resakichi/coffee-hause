package com.coffeehause.web.entity;

import jakarta.persistence.*;
import org.mockito.internal.verification.Times;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
public class Product {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Long product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "cook_time")
    private Time cook_time;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    @OneToMany(targetEntity = Event.class, mappedBy = "product", fetch = FetchType.EAGER)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Time getCook_time() {
        return cook_time;
    }

    public void setCook_time(Time cook_time) {
        this.cook_time = cook_time;
    }

    @Override
    public String toString() {
        return "Product {" + "id=" + this.product_id + " name=" + this.name +
                " price=" + this.price + " cook_time=" + this.cook_time + "}";
    }
}
