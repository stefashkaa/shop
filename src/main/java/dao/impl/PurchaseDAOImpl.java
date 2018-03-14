package dao.impl;

import dao.DAO;
import dao.PurchaseDAO;
import entities.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseDAOImpl implements PurchaseDAO {
    private DAO dao;

    public PurchaseDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addPurchase(Purchase purchase) {
        String query = "INSERT INTO purchase" +
                " (id, product_id, client_id, count, price, address, ord_date, status) VALUES " +
                "(?,?,?,?,?,?,?,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, purchase.getId());
            preparedStatement.setInt(2, purchase.getProductId());
            preparedStatement.setInt(3, purchase.getClientId());
            preparedStatement.setInt(4, purchase.getCount());
            preparedStatement.setInt(5, purchase.getPrice());
            preparedStatement.setString(6, purchase.getAddress());
            preparedStatement.setDate(7, (java.sql.Date) purchase.getOrderDate());
            preparedStatement.setString(8, purchase.getStatus());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Purchase> getPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        String query = "SELECT * FROM purchase";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Purchase purchase = createPurchase(resultSet);
                purchases.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;
    }

    @Override
    public Purchase getPurchase(int id) {
        String query = "SELECT * FROM purchase WHERE ID = ?";
        Purchase purchase = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                purchase = createPurchase(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchase;
    }

    private Purchase createPurchase(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);
        int productId = resultSet.getInt(PRODUCT_ID);
        int clientId = resultSet.getInt(CLIENT_ID);
        int count = resultSet.getInt(COUNT);
        int price = resultSet.getInt(PRICE);
        String address = resultSet.getString(ADDRESS);
        Date orderDate = resultSet.getDate(ORDER_DATE);
        String status = resultSet.getString(STATUS);
        return new Purchase(id, productId, clientId, count, price, address, orderDate, status);
    }
}
