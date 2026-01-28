"""Aufgabe 2: Setup und Teardown selbst implementieren

Diese Testdatei testet ShoppingCart. Die Fixture ``cart`` ist bereits
als Platzhalter vorhanden, aber noch nicht implementiert.

Ihre Aufgaben:
    1. Implementieren Sie die Fixture ``cart``, die einen neuen, leeren
       Warenkorb bereitstellt (Setup) und ihn nach dem Test leert (Teardown).
    2. Implementieren Sie die TODO-Tests.

Schauen Sie sich ``test_aufgabe2_beispiel.py`` als Referenz an.

Hinweis zu Fixtures:
    https://docs.pytest.org/en/stable/how-to/fixtures.html
"""

import pytest

from src.shopping_cart import ShoppingCart  # noqa: F401


# TODO: Implementieren Sie die Fixture "cart", die einen ShoppingCart bereitstellt.
#       Verwenden Sie yield und leeren Sie den Warenkorb im Teardown.
#       Beispiel: siehe test_aufgabe2_beispiel.py


def test_add_item_increases_item_count(cart):
    # Dieser Test schlägt fehl, solange die Fixture cart nicht implementiert ist.
    # Arrange
    item_name = "Taschenrechner"
    item_price = 12.99
    expected_item_count = 1

    # Act
    cart.add_item(item_name, item_price)

    # Assert
    assert cart.get_item_count() == expected_item_count


def test_todo_total_after_multiple_items(cart):
    # TODO: Fügen Sie mehrere Artikel hinzu und prüfen Sie, dass get_total()
    #       die Summe aller Preise zurückgibt.
    pytest.fail("Test noch nicht implementiert")


def test_todo_clear_removes_all_items(cart):
    # TODO: Fügen Sie Artikel hinzu, rufen Sie clear() auf und prüfen Sie,
    #       dass der Warenkorb danach leer ist.
    pytest.fail("Test noch nicht implementiert")


def test_todo_empty_cart_has_zero_total(cart):
    # TODO: Prüfen Sie, dass ein leerer Warenkorb einen Gesamtpreis von 0 hat.
    pytest.fail("Test noch nicht implementiert")
