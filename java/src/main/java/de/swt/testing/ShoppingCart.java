package de.swt.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A shopping cart that holds items with prices.
 */
public class ShoppingCart {

    private final List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the cart.
     *
     * @param name the item name
     * @param price the item price
     */
    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    /**
     * Returns the total price of all items in the cart.
     */
    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.price();
        }
        return total;
    }

    /**
     * Returns the number of items in the cart.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Returns an unmodifiable view of the items in the cart.
     */
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Removes all items from the cart.
     */
    public void clear() {
        items.clear();
    }

    /**
     * An item in the shopping cart.
     */
    public record Item(String name, double price) {}
}
