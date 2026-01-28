"""Aufgabe 3: Mocking selbst implementieren

CheckoutService verwendet ein PaymentGateway zur Zahlungsabwicklung.
Um CheckoutService isoliert zu testen, benötigen Sie einen Mock für das
PaymentGateway.

In Python gibt es keine Interfaces — jedes Objekt mit einer Methode
``process_payment(card_number, amount)`` kann als PaymentGateway verwendet
werden (Duck Typing).

Die Tests sind bereits fertig geschrieben, aber auskommentiert, weil die Klasse
MockPaymentGateway noch fehlt.

Ihre Aufgabe: Erstellen Sie eine Klasse ``MockPaymentGateway`` mit einer Methode
``process_payment(card_number, amount)``, sodass alle Tests grün werden.

Schauen Sie sich ``test_aufgabe3_beispiel.py`` als Referenz an.
"""

# from src.checkout_service import CheckoutService


# TODO: Erstellen Sie hier eine Klasse MockPaymentGateway.
#       Entkommentieren Sie danach die Tests unten.


# def test_checkout_successful():
#     # Arrange
#     card_number = "4111111111111111"
#     amount = 99.99
#     expected_result = "SUCCESS"
#     mock_gateway = MockPaymentGateway()
#     service = CheckoutService(mock_gateway)
#
#     # Act
#     result = service.checkout(card_number, amount)
#
#     # Assert
#     assert result == expected_result


# def test_checkout_invalid_amount():
#     # Arrange
#     card_number = "4111111111111111"
#     amount = -10.00
#     expected_result = "INVALID_AMOUNT"
#     mock_gateway = MockPaymentGateway()
#     service = CheckoutService(mock_gateway)
#
#     # Act
#     result = service.checkout(card_number, amount)
#
#     # Assert
#     assert result == expected_result


# ========================================================================
# Bonus: Dasselbe mit unittest.mock.MagicMock
# ========================================================================

# Python bringt ein mächtiges Mock-Framework in der Standardbibliothek mit:
# ``unittest.mock``. Mit ``MagicMock`` können Sie Mock-Objekte erstellen, ohne
# eine eigene Klasse zu schreiben.
#
# Siehe auch:
#     https://docs.python.org/3/library/unittest.mock.html
#
# Entkommentieren Sie diesen Block, um MagicMock auszuprobieren:

# from unittest.mock import MagicMock
#
# def test_checkout_with_magic_mock():
#     # Arrange
#     card_number = "4111111111111111"
#     amount = 99.99
#     mock_gateway = MagicMock()
#     mock_gateway.process_payment.return_value = True
#     service = CheckoutService(mock_gateway)
#
#     # Act
#     result = service.checkout(card_number, amount)
#
#     # Assert
#     assert result == "SUCCESS"
#     mock_gateway.process_payment.assert_called_once_with(card_number, amount)
