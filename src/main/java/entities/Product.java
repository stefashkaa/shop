package entities;

public class Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private String image;
    private Category category;

    public Product() { }

    public Product(int id) {
        this.id = id;
    }
    
    public Product(String name, String description, int price, String image, Category category) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
