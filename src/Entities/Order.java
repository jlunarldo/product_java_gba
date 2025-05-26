package Entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private final int id;
    private final List<OrderLine> items;

    public Order(List<OrderLine> items) {
        this.id = counter++;
        this.items = items;
    }

    public double getTotal() {
        double total = 0;
        for (OrderLine item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🧾 Order ID: ").append(id).append("\n");
        sb.append("Items:\n");
        for (OrderLine line : items) {
            sb.append(line).append("\n");
        }
        sb.append(String.format("Total: $%.2f", getTotal()));
        return sb.toString();
    }
}
