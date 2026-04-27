package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
private String orderId;
    private List<Item> items;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getOrderId() { return orderId; }
}
