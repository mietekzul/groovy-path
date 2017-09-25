package pl.raziel.dao;

import pl.raziel.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDAO {
    int createAccount(BigDecimal initialBalance);

    Account findAccountById(int id);

    List<Account> findAllAccounts();

    void updateAccount(Account account);

    void deleteAccount(int id);
}
