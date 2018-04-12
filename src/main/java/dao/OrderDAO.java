package dao;

import entities.Cart;
import entities.Order;

public interface OrderDAO {

    int save(Order order);

    void update(Cart cart);
}
