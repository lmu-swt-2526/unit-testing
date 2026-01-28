package de.swt.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aufgabe 1: Bug-Finding mit Unit Tests
 *
 * <p>Die Klasse {@link BankingService} enthält eine Methode {@code transfer}, die Geld
 * von einem Quellkonto auf ein Zielkonto überweist. Laut JavaDoc muss der Betrag
 * größer als null sein, andernfalls soll eine {@link IllegalArgumentException} geworfen werden.
 *
 * <p>Die folgenden Tests prüfen einige Normalfälle. Ihre Aufgabe ist es, weitere Tests
 * zu schreiben, die Fehler in der Implementierung aufdecken.
 */
class Aufgabe1_BugFindingTest {

    private final BankingService bankingService = new BankingService();

    @Test
    void transferMovesMoneyBetweenAccounts() {
        // Arrange
        double amount = 50;
        double sourceBalance = 200;
        double targetBalance = 100;
        double expectedSourceBalance = 150;
        double expectedTargetBalance = 150;

        // Act
        double[] result = bankingService.transfer(amount, sourceBalance, targetBalance);

        // Assert
        assertNotNull(result);
        assertEquals(expectedSourceBalance, result[0], "Quellkonto sollte 150 haben");
        assertEquals(expectedTargetBalance, result[1], "Zielkonto sollte 150 haben");
    }

    @Test
    void transferWithInsufficientFundsReturnsNull() {
        // Arrange
        double amount = 300;
        double sourceBalance = 200;
        double targetBalance = 100;

        // Act
        double[] result = bankingService.transfer(amount, sourceBalance, targetBalance);

        // Assert
        assertNull(result, "Transfer ohne ausreichendes Guthaben sollte null zurückgeben");
    }

    @Test
    void transferSmallAmount() {
        // Arrange
        double amount = 1;
        double sourceBalance = 1000;
        double targetBalance = 0;
        double expectedSourceBalance = 999;
        double expectedTargetBalance = 1;

        // Act
        double[] result = bankingService.transfer(amount, sourceBalance, targetBalance);

        // Assert
        assertNotNull(result);
        assertEquals(expectedSourceBalance, result[0]);
        assertEquals(expectedTargetBalance, result[1]);
    }

    // ========================================================================
    // TODO: Schreiben Sie weitere Tests, die Bugs in BankingService aufdecken.
    // ========================================================================

    @Test
    void todoTransferExactBalance() {
        // TODO: Was passiert, wenn der Betrag genau dem Kontostand entspricht?
        //       Laut Logik sollte das funktionieren — tut es das?
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoTransferNegativeAmount() {
        // TODO: Laut JavaDoc soll eine IllegalArgumentException geworfen werden,
        //       wenn der Betrag <= 0 ist. Prüfen Sie das.
        fail("Test noch nicht implementiert");
    }

    // ========================================================================
    // Referenz: So würde ein korrekter Transfer mit exaktem Kontostand aussehen.
    // Dieser Test ist deaktiviert, weil die aktuelle Implementierung fehlerhaft ist.
    // ========================================================================

    @Disabled("Referenz-Test: schlägt fehl wegen Bug in BankingService")
    @Test
    void referenceTransferExactBalanceShouldWork() {
        // Arrange
        double amount = 200;
        double sourceBalance = 200;
        double targetBalance = 100;
        double expectedSourceBalance = 0;
        double expectedTargetBalance = 300;

        // Act
        double[] result = bankingService.transfer(amount, sourceBalance, targetBalance);

        // Assert
        assertNotNull(result, "Transfer mit exaktem Kontostand sollte funktionieren");
        assertEquals(expectedSourceBalance, result[0]);
        assertEquals(expectedTargetBalance, result[1]);
    }
}
