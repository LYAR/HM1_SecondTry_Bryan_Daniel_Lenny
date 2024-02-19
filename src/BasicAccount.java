public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit > 0 ? withdrawalLimit : 0; // Ensure withdrawal limit is positive
        this.balance = 0; // Initialize balance to 0
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        // The actual amount to withdraw cannot exceed the withdrawalLimit and the current balance
        double actualAmountToWithdraw = Math.min(amount, withdrawalLimit);
        actualAmountToWithdraw = Math.min(actualAmountToWithdraw, balance);
        balance -= actualAmountToWithdraw;
        return actualAmountToWithdraw;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
