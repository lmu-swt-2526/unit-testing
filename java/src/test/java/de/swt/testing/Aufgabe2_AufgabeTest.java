package de.swt.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aufgabe 2: Setup und Teardown selbst implementieren
 *
 * <p>Diese Testklasse testet {@link ShoppingCart}. Das Feld {@code cart} ist bereits
 * deklariert, aber es fehlen {@code @BeforeEach} und {@code @AfterEach}.
 *
 * <p>Ihre Aufgaben:
 * <ol>
 *   <li>Implementieren Sie eine {@code @BeforeEach}-Methode, die {@code cart}
 *       als neuen, leeren Warenkorb initialisiert.</li>
 *   <li>Implementieren Sie eine {@code @AfterEach}-Methode, die den Warenkorb
 *       nach jedem Test leert.</li>
 *   <li>Implementieren Sie die TODO-Tests.</li>
 * </ol>
 *
 * <p>Schauen Sie sich {@link Aufgabe2_BeispielTest} als Referenz an.
 */
class Aufgabe2_AufgabeTest {

    private ShoppingCart cart;

    // TODO: Implementieren Sie eine @BeforeEach-Methode, die cart initialisiert.

    // TODO: Implementieren Sie eine @AfterEach-Methode, die den Warenkorb leert.

    @Test
    void addItemIncreasesItemCount() {
        // Dieser Test schlägt fehl, solange setUp() nicht implementiert ist.
        // Arrange
        String itemName = "Taschenrechner";
        double itemPrice = 12.99;
        int expectedItemCount = 1;

        // Act
        cart.addItem(itemName, itemPrice);

        // Assert
        assertEquals(expectedItemCount, cart.getItemCount());
    }

    @Test
    void todoTotalAfterMultipleItems() {
        // TODO: Fügen Sie mehrere Artikel hinzu und prüfen Sie, dass getTotal()
        //       die Summe aller Preise zurückgibt.
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoClearRemovesAllItems() {
        // TODO: Fügen Sie Artikel hinzu, rufen Sie clear() auf und prüfen Sie,
        //       dass der Warenkorb danach leer ist.
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoEmptyCartHasZeroTotal() {
        // TODO: Prüfen Sie, dass ein leerer Warenkorb einen Gesamtpreis von 0 hat.
        fail("Test noch nicht implementiert");
    }
}
