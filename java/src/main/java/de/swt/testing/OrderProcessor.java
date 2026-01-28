package de.swt.testing;

/**
 * Processes orders and sends confirmation emails.
 */
public class OrderProcessor {

    private final NotificationService emailService;

    public OrderProcessor(NotificationService emailService) {
        this.emailService = emailService;
    }

    /**
     * Processes an order and sends a confirmation notification.
     *
     * @param customerEmail the customer's email address
     * @param amount the order amount
     * @return true if the order was processed and the email was sent
     */
    public boolean processOrder(String customerEmail, double amount) {
        String subject = "Order Confirmation";
        String body = "Your order of %.2f EUR has been processed.".formatted(amount);
        return emailService.notify(customerEmail, subject, body);
    }
}
