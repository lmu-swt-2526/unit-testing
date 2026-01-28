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

    @Test
    void transferMovesMoneyBetweenAccounts() {
        double[] result = BankingService.transfer(50, 200, 100);

        assertNotNull(result);
        assertEquals(150, result[0], "Quellkonto sollte 150 haben");
        assertEquals(150, result[1], "Zielkonto sollte 150 haben");
    }

    @Test
    void transferWithInsufficientFundsReturnsNull() {
        double[] result = BankingService.transfer(300, 200, 100);

        assertNull(result, "Transfer ohne ausreichendes Guthaben sollte null zurückgeben");
    }

    @Test
    void transferSmallAmount() {
        double[] result = BankingService.transfer(1, 1000, 0);

        assertNotNull(result);
        assertEquals(999, result[0]);
        assertEquals(1, result[1]);
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
        double[] result = BankingService.transfer(200, 200, 100);

        assertNotNull(result, "Transfer mit exaktem Kontostand sollte funktionieren");
        assertEquals(0, result[0]);
        assertEquals(300, result[1]);
    }
}
