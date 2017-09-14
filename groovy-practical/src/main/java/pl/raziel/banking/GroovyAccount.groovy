package pl.raziel.banking

import groovy.transform.Canonical

@Canonical
class GroovyAccount implements Account {
    Integer id
    BigDecimal balance


    @Override
    double deposit(BigDecimal amount) {
        balance += amount
    }

    @Override
    double withdraw(BigDecimal amount) {
        deposit(-amount)
    }

    @Override
    double getBalance() {
        balance
    }
}
