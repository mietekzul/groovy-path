package pl.raziel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.raziel.entities.Account;
import pl.raziel.repositories.AccountRepository;

import java.math.BigDecimal;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BigDecimal getAccountBalance(int id) {
        Account account = accountRepository.findOne(id);
        return account.getBalance();
    }

    public BigDecimal depositIntoAcoount(int id, BigDecimal amount) {
        Account account = accountRepository.findOne(id);
        account.deposit(amount);
        accountRepository.save(account);
        return account.getBalance();
    }

    public BigDecimal withdrawFromAccount(int id, BigDecimal amount){
        Account account = accountRepository.findOne(id);
        account.withdraw(amount);
        accountRepository.save(account);
        return account.getBalance();
    }
}
