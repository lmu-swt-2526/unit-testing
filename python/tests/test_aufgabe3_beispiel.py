"""Beispiel: Manuelles Mocking

Beim Testen wollen wir oft externe Abhängigkeiten ersetzen, damit Tests schnell
und isoliert laufen. Ein manueller Mock ist eine Klasse, die das Verhalten der
echten Klasse ersetzt und die Aufrufe aufzeichnet.

In Python nutzen wir Duck Typing: Jedes Objekt, das die erwarteten Methoden
bereitstellt, kann als Ersatz verwendet werden — es sind keine Interfaces nötig.

Hier wird der NotificationService durch einen MockNotificationService ersetzt,
um OrderProcessor isoliert zu testen.
"""

from src.order_processor import OrderProcessor


class MockNotificationService:
    """Mock für einen NotificationService, der keine echte Benachrichtigung
    sendet, sondern die Aufrufe aufzeichnet."""

    def __init__(self):
        self.was_called = False
        self.last_to = None
        self.last_subject = None
        self.last_body = None
        self.return_value = True

    def notify(self, to, subject, body):
        self.was_called = True
        self.last_to = to
        self.last_subject = subject
        self.last_body = body
        return self.return_value


def test_order_processor_sends_confirmation_email():
    # Arrange
    customer_email = "test@example.com"
    order_amount = 42.50
    expected_subject = "Order Confirmation"
    mock_email = MockNotificationService()
    processor = OrderProcessor(mock_email)

    # Act
    result = processor.process_order(customer_email, order_amount)

    # Assert
    assert result is True
    assert mock_email.was_called, "NotificationService sollte aufgerufen worden sein"
    assert mock_email.last_to == customer_email
    assert mock_email.last_subject == expected_subject
    assert "42" in mock_email.last_body, "Body sollte den Betrag enthalten"


def test_order_processor_handles_email_failure():
    # Arrange
    customer_email = "test@example.com"
    order_amount = 10.00
    mock_email = MockNotificationService()
    mock_email.return_value = False
    processor = OrderProcessor(mock_email)

    # Act
    result = processor.process_order(customer_email, order_amount)

    # Assert
    assert result is False, (
        "process_order sollte False zurückgeben, wenn E-Mail fehlschlägt"
    )
