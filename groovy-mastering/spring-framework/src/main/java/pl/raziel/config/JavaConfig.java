package pl.raziel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.raziel.dao.AccountDAO;
import pl.raziel.services.AccountProcessor;

@Configuration
public class JavaConfig {
    @Autowired
    private AccountDAO accountDAO;

    @Bean
    public AccountProcessor accountProcessor() {
        AccountProcessor ap = new AccountProcessor();
        ap.setAccounts(accountDAO.findAllAccounts());
        return ap;
    }
}
