package dao.impl;

import dao.ProductDAO;
import entities.Category;
import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOImpl implements ProductDAO {

    public ProductDAOImpl() { }
    
    @Override
    public List<Product> findAll(int max) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY id DESC LIMIT ?";
        addProduct(max, products, sql);
        return products;
    }

    private void addProduct(int max, List<Product> products, String sql) {
        try (Connection connection = DBConnection.getInstance().getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, max);
            ResultSet rs = ps.executeQuery();
            Product product;
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Product> findByCategory(int id) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE category_id = ? ORDER BY id DESC";
        addProduct(id, products, sql);
        return products;
    }

    @Override
    public List<Product> search(String q) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ? ORDER BY id DESC";

        try (Connection connection = DBConnection.getInstance().getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            StringBuilder sb = new StringBuilder();
            sb.append("%").append(q).append("%");
            ps.setString(1, sb.toString());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public Product find(int id) {
        Product product = null;

        String sql = "SELECT product.*, category.name AS category_name "
                   + "FROM product "
                   + "LEFT JOIN category "
                   + "ON product.category_id = category.id "
                   + "WHERE product.id = ?";

        try (Connection connection = DBConnection.getInstance().getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                product.setCategory(
                    new Category(rs.getInt("category_id"), rs.getString("category_name")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
}
