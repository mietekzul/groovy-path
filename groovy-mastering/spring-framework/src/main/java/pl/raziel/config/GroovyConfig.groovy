package pl.raziel.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import pl.raziel.dao.AccountDAO
import pl.raziel.entities.Account

@Configuration
class GroovyConfig {
    @Autowired
    AccountDAO dao;

    @Bean
    @Scope("prototype")
    Account prototypeAccount() {
        int newId = dao.createAccount(100.0)
        new Account(id: newId, balance: 100.0)
    }
}
