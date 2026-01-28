package de.swt.testing;

/**
 * Service that handles the checkout process using a payment gateway.
 */
public class CheckoutService {

    private final PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    /**
     * Performs checkout with the given card and amount.
     *
     * @param cardNumber the card number
     * @param amount the payment amount
     * @return "INVALID_AMOUNT" if amount is not positive,
     *         "SUCCESS" if payment succeeds,
     *         "PAYMENT_FAILED" otherwise
     */
    public String checkout(String cardNumber, double amount) {
        if (amount <= 0) {
            return "INVALID_AMOUNT";
        }
        boolean success = paymentGateway.processPayment(cardNumber, amount);
        return success ? "SUCCESS" : "PAYMENT_FAILED";
    }
}
