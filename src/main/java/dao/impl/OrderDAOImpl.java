package dao.impl;

import dao.OrderDAO;
import entities.Item;
import entities.Order;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAOImpl implements OrderDAO {

    public OrderDAOImpl() { }
    
    @Override
    public int save(Order order) {
        int ret = -1;

        try (Connection connection = DBConnection.getInstance().getConnection()){
            String sql = "INSERT INTO orders(name, phone, address, note, created, client_id) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getName());
            ps.setString(2, order.getPhone());
            ps.setString(3, order.getAddress());
            ps.setString(4, order.getNote());
            ps.setTimestamp(5, new Timestamp(order.getCreated().getTime()));
            ps.setInt(6, order.getUser().getId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
                
                sql = "INSERT INTO item(product_id, quantity, price, order_id) VALUES ";
                int count;
                for (count = 0; count < order.getItems().size(); count++) {
                    if (count != order.getItems().size() - 1) {
                        sql += "(?, ?, ?, ?), ";
                    } else {
                        sql += "(?, ?, ?, ?)";
                    }
                }
                ps = connection.prepareStatement(sql);
                count = 1;
                for (Item item : order.getItems()) {
                    ps.setInt(count++, item.getProduct().getId());
                    ps.setInt(count++, item.getQuantity());
                    ps.setInt(count++, item.getProduct().getPrice());
                    ps.setInt(count++, ret);
                }
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

}
