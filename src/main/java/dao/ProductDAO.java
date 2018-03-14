package dao;

import entities.Product;
import java.util.List;

public interface ProductDAO extends EntityDAO {
    String NAME = "name";
    String PRICE = "price";
    String COUNT = "count";
    String CATEGORY_ID = "category_id";
    String IMAGE = "image";
    String DESCRIPTION = "description";

    List<Product> getProducts();

    Product getProduct(String name);

    Product getProduct(int id);
}
