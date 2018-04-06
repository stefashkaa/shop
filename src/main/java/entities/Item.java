package entities;

public class Item {

    private Product product;
    private int quantity;
    private int price;
    private Order order;

    public Item() { }

    public Item(Product product, int quantity) {
        super();
        this.product = product;
        this.quantity = quantity;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getSubTotal() {
        return product.getPrice() * quantity;
    }
}
