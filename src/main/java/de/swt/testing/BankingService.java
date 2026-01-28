package de.swt.testing;

/**
 * Service for banking operations.
 */
public class BankingService {

    /**
     * Transfers the given amount from a source account to a target account.
     *
     * @param amount the amount to transfer, must be greater than zero
     * @param sourceBalance the current balance of the source account
     * @param targetBalance the current balance of the target account
     * @return a two-element array with the new source and target balances
     * @throws IllegalArgumentException if amount is not greater than zero
     */
    public static double[] transfer(double amount, double sourceBalance, double targetBalance) {
        // Bug 2: missing validation — no IllegalArgumentException for amount <= 0
        // Bug 1: uses > instead of >= so exact balance fails
        if (sourceBalance > amount) {
            return new double[]{sourceBalance - amount, targetBalance + amount};
        }
        return null;
    }
}
