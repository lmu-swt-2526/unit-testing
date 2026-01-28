package de.swt.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aufgabe 3: Mocking — von Hand und mit Mockito
 *
 * <p>Beim Testen wollen wir oft externe Abhängigkeiten ersetzen, damit Tests schnell
 * und isoliert laufen. Dafür gibt es zwei Ansätze:
 * <ul>
 *   <li>Manuelles Mocking: Eine eigene Unterklasse oder Implementierung schreiben</li>
 *   <li>Mockito: Ein Framework, das Mock-Objekte automatisch erzeugt</li>
 * </ul>
 *
 * <p>In dieser Aufgabe sehen Sie zunächst ein Beispiel für manuelles Mocking mit
 * {@link EmailService} und {@link OrderProcessor}. Danach implementieren Sie selbst
 * ein Mock für {@link PaymentGateway} und testen {@link CheckoutService}.
 */
class Aufgabe3_MocksTest {

    // ========================================================================
    // Beispiel: Manuelles Mocking von EmailService
    // ========================================================================

    /**
     * Ein Mock für {@link EmailService}, der keine echte E-Mail sendet, sondern
     * die Aufrufe aufzeichnet.
     */
    static class MockEmailService extends EmailService {
        boolean wasCalled = false;
        String lastTo;
        String lastSubject;
        String lastBody;
        boolean returnValue = true;

        @Override
        public boolean sendEmail(String to, String subject, String body) {
            wasCalled = true;
            lastTo = to;
            lastSubject = subject;
            lastBody = body;
            return returnValue;
        }
    }

    @Test
    void orderProcessorSendsConfirmationEmail() {
        MockEmailService mockEmail = new MockEmailService();
        OrderProcessor processor = new OrderProcessor(mockEmail);

        boolean result = processor.processOrder("test@example.com", 42.50);

        assertTrue(result);
        assertTrue(mockEmail.wasCalled, "EmailService sollte aufgerufen worden sein");
        assertEquals("test@example.com", mockEmail.lastTo);
        assertEquals("Order Confirmation", mockEmail.lastSubject);
        assertTrue(mockEmail.lastBody.contains("42"), "Body sollte den Betrag enthalten");
    }

    @Test
    void orderProcessorHandlesEmailFailure() {
        MockEmailService mockEmail = new MockEmailService();
        mockEmail.returnValue = false;
        OrderProcessor processor = new OrderProcessor(mockEmail);

        boolean result = processor.processOrder("test@example.com", 10.00);

        assertFalse(result, "processOrder sollte false zurückgeben, wenn E-Mail fehlschlägt");
    }

    // ========================================================================
    // TODO: Manuelles Mocking von PaymentGateway
    // ========================================================================

    // TODO: Erstellen Sie hier eine innere Klasse MockPaymentGateway, die das
    //       Interface PaymentGateway implementiert. Die Klasse soll:
    //       - aufzeichnen, ob processPayment aufgerufen wurde
    //       - die übergebenen Parameter (cardNumber, amount) speichern
    //       - einen konfigurierbaren Rückgabewert haben (default: true)

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
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        when(mockGateway.processPayment("4111111111111111", 99.99)).thenReturn(true);

        CheckoutService service = new CheckoutService(mockGateway);
        String result = service.checkout("4111111111111111", 99.99);

        assertEquals("SUCCESS", result);
        verify(mockGateway).processPayment("4111111111111111", 99.99);
    }
    */
}
