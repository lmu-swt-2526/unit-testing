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
 * <p>Die Tests sind bereits fertig geschrieben, kompilieren aber nicht, weil die Klasse
 * {@code MockPaymentGateway} noch fehlt.
 *
 * <p>Ihre Aufgabe: Erstellen Sie eine innere Klasse {@code MockPaymentGateway}, die
 * {@link PaymentGateway} implementiert, sodass alle Tests kompilieren und grün werden.
 *
 * <p>Schauen Sie sich {@link Aufgabe3_BeispielTest} als Referenz an.
 */
class Aufgabe3_AufgabeTest {

    // TODO: Erstellen Sie hier eine innere Klasse MockPaymentGateway, die das
    //       Interface PaymentGateway implementiert.
    //       Entkommentieren Sie danach die Tests unten.

    /*
    @Test
    void checkoutSuccessful() {
        // Arrange
        String cardNumber = "4111111111111111";
        double amount = 99.99;
        String expectedResult = "SUCCESS";
        MockPaymentGateway mockGateway = new MockPaymentGateway();
        CheckoutService service = new CheckoutService(mockGateway);

        // Act
        String result = service.checkout(cardNumber, amount);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void checkoutInvalidAmount() {
        // Arrange
        String cardNumber = "4111111111111111";
        double amount = -10.00;
        String expectedResult = "INVALID_AMOUNT";
        MockPaymentGateway mockGateway = new MockPaymentGateway();
        CheckoutService service = new CheckoutService(mockGateway);

        // Act
        String result = service.checkout(cardNumber, amount);

        // Assert
        assertEquals(expectedResult, result);
    }
    */

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
