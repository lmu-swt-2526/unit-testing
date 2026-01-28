package de.swt.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Beispiel: Setup und Teardown mit {@code @BeforeEach} und {@code @AfterEach}
 *
 * <p>Die Klasse {@link ShoppingCart} ist ein Warenkorb, dem Artikel hinzugefügt werden
 * können. Vor jedem Test wird ein leerer Warenkorb erstellt, nach jedem Test wird er
 * geleert.
 *
 * <p>{@code @BeforeEach} wird vor jedem Test ausgeführt und eignet sich für die
 * Initialisierung gemeinsamer Objekte. {@code @AfterEach} wird nach jedem Test
 * ausgeführt und eignet sich zum Aufräumen von Ressourcen.
 */
class Aufgabe2_BeispielTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @AfterEach
    void tearDown() {
        cart.clear();
    }

    @Test
    void addItemIncreasesTotal() {
        // Arrange
        String itemName = "Notebook";
        double itemPrice = 999.99;
        double expectedTotal = 999.99;

        // Act
        cart.addItem(itemName, itemPrice);

        // Assert
        assertEquals(expectedTotal, cart.getTotal());
    }

    @Test
    void addMultipleItemsSumsTotal() {
        // Arrange
        double expectedTotal = 34.97;
        cart.addItem("Stift", 1.99);
        cart.addItem("Heft", 2.99);
        cart.addItem("Buch", 29.99);

        // Act
        double total = cart.getTotal();

        // Assert
        assertEquals(expectedTotal, total, 0.001);
    }

    @Test
    void emptyCartHasZeroItems() {
        // Act
        int itemCount = cart.getItemCount();

        // Assert
        assertEquals(0, itemCount);
    }
}
