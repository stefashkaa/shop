package entities;

public class Product {
    private int id;
    private String name;
    private int price;
    private int count;
    private int categoryId;
    private String image;
    private String description;

    public Product() {}

    public Product(int id, String name, int price, int count, int categoryId,
                   String image, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.categoryId = categoryId;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
