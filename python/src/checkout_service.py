"""Service that handles the checkout process using a payment gateway."""


class CheckoutService:
    """Handles the checkout process using a payment gateway.

    The payment_gateway must be any object with a
    ``process_payment(card_number, amount)`` method that returns a bool.
    """

    def __init__(self, payment_gateway):
        self._payment_gateway = payment_gateway

    def checkout(self, card_number, amount):
        """Perform checkout with the given card and amount.

        Args:
            card_number: The card number.
            amount: The payment amount.

        Returns:
            "INVALID_AMOUNT" if amount is not positive,
            "SUCCESS" if payment succeeds,
            "PAYMENT_FAILED" otherwise.
        """
        if amount <= 0:
            return "INVALID_AMOUNT"
        success = self._payment_gateway.process_payment(card_number, amount)
        return "SUCCESS" if success else "PAYMENT_FAILED"
