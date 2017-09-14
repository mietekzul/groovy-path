package pl.raziel.banking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    Bank(List<Account> accountList) {
        accountList.stream().forEach(a -> accounts.put(a.getId(), a));
    }

    double deposit(int id, double amount) {
        return accounts.get(id).deposit(new BigDecimal(amount + ""));
    }

    double withdraw(int id, double amount) {
        return accounts.get(id).withdraw(new BigDecimal(amount + ""));
    }

    double getBalance(int id) {
        return accounts.get(id).getBalance();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("accounts=").append(accounts);
        sb.append('}');
        return sb.toString();
    }
}
