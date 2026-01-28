"""Aufgabe 1: Bug-Finding mit Unit Tests

Die Klasse BankingService enthält eine Methode ``transfer``, die Geld von einem
Quellkonto auf ein Zielkonto überweist. Laut Docstring muss der Betrag größer
als null sein, andernfalls soll ein ``ValueError`` geworfen werden.

Die folgenden Tests prüfen einige Normalfälle. Ihre Aufgabe ist es, weitere Tests
zu schreiben, die Fehler in der Implementierung aufdecken.
"""

import pytest

from src.banking_service import BankingService


@pytest.fixture
def banking_service():
    return BankingService()


def test_transfer_moves_money_between_accounts(banking_service):
    # Arrange
    amount = 50
    source_balance = 200
    target_balance = 100
    expected_source_balance = 150
    expected_target_balance = 150

    # Act
    result = banking_service.transfer(amount, source_balance, target_balance)

    # Assert
    assert result is not None
    assert result[0] == expected_source_balance, "Quellkonto sollte 150 haben"
    assert result[1] == expected_target_balance, "Zielkonto sollte 150 haben"


def test_transfer_with_insufficient_funds_returns_none(banking_service):
    # Arrange
    amount = 300
    source_balance = 200
    target_balance = 100

    # Act
    result = banking_service.transfer(amount, source_balance, target_balance)

    # Assert
    assert result is None, (
        "Transfer ohne ausreichendes Guthaben sollte None zurückgeben"
    )


def test_transfer_small_amount(banking_service):
    # Arrange
    amount = 1
    source_balance = 1000
    target_balance = 0
    expected_source_balance = 999
    expected_target_balance = 1

    # Act
    result = banking_service.transfer(amount, source_balance, target_balance)

    # Assert
    assert result is not None
    assert result[0] == expected_source_balance
    assert result[1] == expected_target_balance


# ========================================================================
# TODO: Schreiben Sie weitere Tests, die Bugs in BankingService aufdecken.
# ========================================================================


def test_todo_transfer_exact_balance(banking_service):
    # TODO: Was passiert, wenn der Betrag genau dem Kontostand entspricht?
    #       Laut Logik sollte das funktionieren — tut es das?
    pytest.fail("Test noch nicht implementiert")


def test_todo_transfer_negative_amount(banking_service):
    # TODO: Laut Docstring soll ein ValueError geworfen werden,
    #       wenn der Betrag <= 0 ist. Prüfen Sie das.
    pytest.fail("Test noch nicht implementiert")


# ========================================================================
# Referenz: So würde ein korrekter Transfer mit exaktem Kontostand aussehen.
# Dieser Test ist deaktiviert, weil die aktuelle Implementierung fehlerhaft ist.
# ========================================================================


@pytest.mark.skip(reason="Referenz-Test: schlägt fehl wegen Bug in BankingService")
def test_reference_transfer_exact_balance_should_work(banking_service):
    # Arrange
    amount = 200
    source_balance = 200
    target_balance = 100
    expected_source_balance = 0
    expected_target_balance = 300

    # Act
    result = banking_service.transfer(amount, source_balance, target_balance)

    # Assert
    assert result is not None, "Transfer mit exaktem Kontostand sollte funktionieren"
    assert result[0] == expected_source_balance
    assert result[1] == expected_target_balance
