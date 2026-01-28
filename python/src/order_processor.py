"""Processes orders and sends confirmation emails."""


class OrderProcessor:
    """Processes orders and sends confirmation notifications.

    The notification_service must be any object with a
    ``notify(to, subject, body)`` method that returns a bool.
    """

    def __init__(self, notification_service):
        self._notification_service = notification_service

    def process_order(self, customer_email, amount):
        """Process an order and send a confirmation notification.

        Args:
            customer_email: The customer's email address.
            amount: The order amount.

        Returns:
            True if the order was processed and the notification was sent.
        """
        subject = "Order Confirmation"
        body = f"Your order of {amount:.2f} EUR has been processed."
        return self._notification_service.notify(customer_email, subject, body)
