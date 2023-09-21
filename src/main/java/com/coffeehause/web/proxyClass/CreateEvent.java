package com.coffeehause.web.proxyClass;

public class CreateEvent {
    private String reason;
    private int stage_id;
    private int order_id;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStage_id() {
        return stage_id;
    }

    public void setStage_id(int stage_id) {
        this.stage_id = stage_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "{" + this.reason + "," + this.stage_id + "," + this.order_id + "}";
    }
}
