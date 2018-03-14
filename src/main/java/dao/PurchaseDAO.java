package dao;

import entities.Purchase;
import java.util.List;

public interface PurchaseDAO extends EntityDAO {
    String CLIENT_ID = "client_id";
    String PRODUCT_ID = "product_id";
    String COUNT = "count";
    String PRICE = "price";
    String ADDRESS = "address";
    String ORDER_DATE = "ord_date";
    String STATUS = "status";

    void addPurchase(Purchase purchase);

    List<Purchase> getPurchases();

    Purchase getPurchase(int id);
}
