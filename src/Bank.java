import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        // Use an iterator to safely remove accounts while iterating
        Iterator<IAccount> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            IAccount account = iterator.next();
            if (account.getAccountNumber() == accountNumber) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double minBalance) {
        List<IAccount> accountsWithMinBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() >= minBalance) {
                accountsWithMinBalance.add(account);
            }
        }
        return accountsWithMinBalance;
    }
}