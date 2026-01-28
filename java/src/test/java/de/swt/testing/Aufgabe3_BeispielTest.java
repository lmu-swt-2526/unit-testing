package de.swt.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Beispiel: Manuelles Mocking
 *
 * <p>Beim Testen wollen wir oft externe Abhängigkeiten ersetzen, damit Tests schnell
 * und isoliert laufen. Ein manueller Mock ist eine Unterklasse oder Implementierung,
 * die das Verhalten der echten Klasse ersetzt und die Aufrufe aufzeichnet.
 *
 * <p>Hier wird {@link NotificationService} durch einen {@link MockNotificationService} ersetzt, um
 * {@link OrderProcessor} isoliert zu testen.
 */
class Aufgabe3_BeispielTest {

    /**
     * Ein Mock für {@link NotificationService}, der keine echte Notification sendet, sondern
     * die Aufrufe aufzeichnet.
     */
    private static class MockNotificationService implements NotificationService {
        boolean wasCalled = false;
        String lastTo;
        String lastSubject;
        String lastBody;
        boolean returnValue = true;

        @Override
        public boolean notify(String to, String subject, String body) {
            wasCalled = true;
            lastTo = to;
            lastSubject = subject;
            lastBody = body;
            return returnValue;
        }
    }

    @Test
    void orderProcessorSendsConfirmationEmail() {
        // Arrange
        String customerEmail = "test@example.com";
        double orderAmount = 42.50;
        String expectedSubject = "Order Confirmation";
        MockNotificationService mockEmail = new MockNotificationService();
        OrderProcessor processor = new OrderProcessor(mockEmail);

        // Act
        boolean result = processor.processOrder(customerEmail, orderAmount);

        // Assert
        assertTrue(result);
        assertTrue(mockEmail.wasCalled, "EmailService sollte aufgerufen worden sein");
        assertEquals(customerEmail, mockEmail.lastTo);
        assertEquals(expectedSubject, mockEmail.lastSubject);
        assertTrue(mockEmail.lastBody.contains("42"), "Body sollte den Betrag enthalten");
    }

    @Test
    void orderProcessorHandlesEmailFailure() {
        // Arrange
        String customerEmail = "test@example.com";
        double orderAmount = 10.00;
        MockNotificationService mockEmail = new MockNotificationService();
        mockEmail.returnValue = false;
        OrderProcessor processor = new OrderProcessor(mockEmail);

        // Act
        boolean result = processor.processOrder(customerEmail, orderAmount);

        // Assert
        assertFalse(result, "processOrder sollte false zurückgeben, wenn E-Mail fehlschlägt");
    }
}
