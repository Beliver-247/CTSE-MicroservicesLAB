package com.ctse.orderservice.model;

public class Order {

    private Long id;
    private String item;
    private int quantity;
    private String customerId;
    private String status;

    public Order() {
    }

    public Order(Long id, String item, int quantity, String customerId, String status) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.customerId = customerId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
