package dao;

import entities.Category;
import java.util.List;

public interface CategoryDAO {

    List<Category> findAll();
}
