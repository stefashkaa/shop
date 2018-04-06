package entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static final int LIMIT_ITEMS = 10;
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }
    
    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        for (Item e : items) {
            if (e.equals(item)) {
                if (e.getQuantity() + item.getQuantity() <= LIMIT_ITEMS) {
                    e.setQuantity(e.getQuantity() + item.getQuantity());
                } else {
                    e.setQuantity(LIMIT_ITEMS);
                }
                return;
            }
        }
        items.add(item);
    }

    public void remove(int id) {
        for (Item e : items) {
            if (e.getProduct().getId() == id) {
                items.remove(e);
                break;
            }
        }
    }

    public int getCount() {
        return items.size();
    }

    public int getTotal() {
        int total = 0;
        for (Item e : items) {
            total += e.getSubTotal();
        }
        return total;
    }
}