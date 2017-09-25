package pl.raziel.services

import pl.raziel.entities.Account

class AccountProcessor {
    List<Account> accounts
    BigDecimal monthlyFee = 1.0

    def processAccounts() {
        accounts.collect { a ->
            a.withdraw(monthlyFee)
            monthlyFee
        }.sum()
    }
}
