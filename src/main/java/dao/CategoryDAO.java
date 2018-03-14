package dao;

import entities.Category;
import entities.Product;

import java.util.List;

public interface CategoryDAO extends EntityDAO {
    String NAME = "name";

    List<Category> getCategories();

    Category getCategory(String name);

    Category getCategory(int id);
}
