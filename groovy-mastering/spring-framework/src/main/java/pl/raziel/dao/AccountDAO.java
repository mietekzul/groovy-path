package pl.raziel.dao;

import org.springframework.stereotype.Component;
import pl.raziel.entities.Account;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface AccountDAO {
    int createAccount(BigDecimal initialBalance);

    Account findAccountById(int id);

    List<Account> findAllAccounts();

    void updateAccount(Account account);

    void deleteAccount(int id);
}
