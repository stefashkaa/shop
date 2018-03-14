package dao.impl;

import dao.DAO;
import dao.ProductDAO;
import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private DAO dao;

    public ProductDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = createProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(String name) {
        String query = "SELECT * FROM product WHERE NAME = ?";
        Product product = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = createProduct(resultSet);
            }
            product = createProduct(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product getProduct(int id) {
        String query = "SELECT * FROM product WHERE ID = ?";
        Product product = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = createProduct(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    private Product createProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);
        String name = resultSet.getString(NAME);
        int price = resultSet.getInt(PRICE);
        int count = resultSet.getInt(COUNT);
        int categoryId = resultSet.getInt(CATEGORY_ID);
        String image = resultSet.getString(IMAGE);
        String description = resultSet.getString(DESCRIPTION);
        return new Product(id, name, price, count, categoryId, image, description);
    }
}
