package de.swt.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aufgabe 3: Mocking selbst implementieren
 *
 * <p>{@link CheckoutService} verwendet ein {@link PaymentGateway} zur Zahlungsabwicklung.
 * Um {@code CheckoutService} isoliert zu testen, benötigen Sie einen Mock für das
 * {@code PaymentGateway}-Interface.
 *
 * <p>Ihre Aufgaben:
 * <ol>
 *   <li>Erstellen Sie eine innere Klasse {@code MockPaymentGateway}, die
 *       {@link PaymentGateway} implementiert. Die Klasse soll:
 *       <ul>
 *         <li>aufzeichnen, ob {@code processPayment} aufgerufen wurde</li>
 *         <li>die übergebenen Parameter ({@code cardNumber}, {@code amount}) speichern</li>
 *         <li>einen konfigurierbaren Rückgabewert haben (default: {@code true})</li>
 *       </ul>
 *   </li>
 *   <li>Implementieren Sie die TODO-Tests.</li>
 * </ol>
 *
 * <p>Schauen Sie sich {@link Aufgabe3_BeispielTest} als Referenz an.
 */
class Aufgabe3_AufgabeTest {

    // TODO: Erstellen Sie hier eine innere Klasse MockPaymentGateway, die das
    //       Interface PaymentGateway implementiert.

    @Test
    void todoCheckoutSuccessful() {
        // TODO: Erstellen Sie einen MockPaymentGateway, der true zurückgibt.
        //       Erstellen Sie einen CheckoutService mit diesem Mock.
        //       Prüfen Sie, dass checkout "SUCCESS" zurückgibt und der Mock
        //       mit den richtigen Parametern aufgerufen wurde.
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoCheckoutPaymentFailed() {
        // TODO: Erstellen Sie einen MockPaymentGateway, der false zurückgibt.
        //       Prüfen Sie, dass checkout "PAYMENT_FAILED" zurückgibt.
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoCheckoutInvalidAmount() {
        // TODO: Prüfen Sie, dass checkout mit amount <= 0 direkt "INVALID_AMOUNT"
        //       zurückgibt, ohne den PaymentGateway aufzurufen.
        fail("Test noch nicht implementiert");
    }

    // ========================================================================
    // Bonus: Dasselbe mit Mockito
    // ========================================================================

    /*
    // Entkommentieren Sie diesen Block, um Mockito auszuprobieren:

    import static org.mockito.Mockito.*;

    @Test
    void checkoutWithMockito() {
        // Arrange
        String cardNumber = "4111111111111111";
        double amount = 99.99;
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        when(mockGateway.processPayment(cardNumber, amount)).thenReturn(true);
        CheckoutService service = new CheckoutService(mockGateway);

        // Act
        String result = service.checkout(cardNumber, amount);

        // Assert
        assertEquals("SUCCESS", result);
        verify(mockGateway).processPayment(cardNumber, amount);
    }
    */
}
