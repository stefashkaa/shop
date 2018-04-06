package dao.impl;

import dao.CategoryDAO;
import entities.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAOImpl implements CategoryDAO {

    public CategoryDAOImpl() { }
    
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        try (Connection connection = DBConnection.getInstance().getConnection()){
            String sql = "SELECT * FROM category";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Category category;
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
}
