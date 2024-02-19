//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create the bank
        Bank bank = new Bank();

        // Create and open accounts
        StandardAccount standardAccount = new StandardAccount(1, -500);
        BasicAccount basicAccount = new BasicAccount(2, 200);
        PremiumAccount premiumAccount = new PremiumAccount(3);

        bank.openAccount(standardAccount);
        bank.openAccount(basicAccount);
        bank.openAccount(premiumAccount);

        // Perform some transactions
        standardAccount.deposit(1000);
        basicAccount.deposit(500);
        premiumAccount.deposit(1500);

        standardAccount.withdraw(1200); // Should be fine, within credit limit
        basicAccount.withdraw(300); // Within withdrawal limit
        premiumAccount.withdraw(1600); // Should be fine, no limit

        // Display all accounts
        System.out.println("All Accounts:");
        for (IAccount account : bank.getAllAccounts()) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getCurrentBalance());
        }

        // Display accounts in debt
        System.out.println("\nAccounts in Debt:");
        for (IAccount account : bank.getAllAccountsInDebt()) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getCurrentBalance());
        }

        // Display accounts with balance greater than 200
        System.out.println("\nAccounts with Balance >= 200:");
        for (IAccount account : bank.getAllAccountsWithBalance(200)) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getCurrentBalance());
        }

        // Closing an account
        bank.closeAccount(2); // Close the BasicAccount
        System.out.println("\nAfter closing Account 2:");
        for (IAccount account : bank.getAllAccounts()) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getCurrentBalance());
        }
    }
}
