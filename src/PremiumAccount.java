public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Initialize balance to 0
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        // Since there's no credit limit, the withdrawal is only limited by the current balance
        double actualAmountToWithdraw = amount > balance ? balance : amount;
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
