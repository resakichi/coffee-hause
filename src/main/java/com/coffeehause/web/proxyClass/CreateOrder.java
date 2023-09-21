package com.coffeehause.web.proxyClass;

public class CreateOrder {
    public String client_name;
    public int product_id;

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "{client:" + this.client_name + ", prod:" + this.product_id + "}";
    }
}
