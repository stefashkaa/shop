package dao;

import entities.Product;
import java.util.List;

public interface ProductDAO {

    List<Product> findAll(int max);
    List<Product> findByCategory(int id);
    List<Product> search(String q);
    Product find(int id);
}
