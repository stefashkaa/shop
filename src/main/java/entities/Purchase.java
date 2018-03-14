package entities;

import java.util.Date;

public class Purchase {

    private int id;
    private int productId;
    private int clientId;
    private int count;
    private int price;
    private String address;
    private Date orderDate;
    private String status;

    public Purchase() {}

    public Purchase(int id, int productId, int clientId, int count, int price, String address,
        Date orderDate, String status) {
        this.id = id;
        this.productId = productId;
        this.clientId = clientId;
        this.count = count;
        this.price = price;
        this.address = address;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
