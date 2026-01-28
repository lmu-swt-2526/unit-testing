"""Service for banking operations."""


class BankingService:
    """Service for banking operations."""

    def transfer(self, amount, source_balance, target_balance):
        """Transfer the given amount from a source account to a target account.

        Args:
            amount: The amount to transfer, must be greater than zero.
            source_balance: The current balance of the source account.
            target_balance: The current balance of the target account.

        Returns:
            A tuple (new_source_balance, new_target_balance).

        Raises:
            ValueError: If amount is not greater than zero.
        """
        # Bug: uses > instead of >=, so exact balance fails
        if source_balance > amount:
            return (source_balance - amount, target_balance + amount)
        # Bug: returns None instead of raising ValueError for negative amounts
        return None
