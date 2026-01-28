package de.swt.testing;

/**
 * Interface for processing payments.
 */
public interface PaymentGateway {

    /**
     * Processes a payment with the given card number and amount.
     *
     * @param cardNumber the card number
     * @param amount the payment amount
     * @return true if the payment was successful
     */
    boolean processPayment(String cardNumber, double amount);
}
