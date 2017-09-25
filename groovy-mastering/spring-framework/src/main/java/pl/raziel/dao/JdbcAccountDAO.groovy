package pl.raziel.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import pl.raziel.entities.Account

import javax.sql.DataSource
import java.sql.ResultSet

@Component
class JdbcAccountDAO implements AccountDAO {
    static int nextId = 3
    JdbcTemplate jdbcTemplate

    @Autowired
    JdbcAccountDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource)
    }

    int createAccount(BigDecimal initialBalance) {
        String sql = "insert into accounts(id,balance) values(?,?)"
        int id = nextId++
        int uc = jdbcTemplate.update(sql, id, initialBalance)
        return uc
    }

    Account findAccountById(int id) {
        String sql = "select * from accounts where id=?"
        jdbcTemplate.queryForObject(sql, accountMapper, id)
    }

//    Java approach: inner class
//    class AccountMapper implements RowMapper<Account> {
//        @Override
//        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new Account(); // create Account from rs
//        }
//    }

    List<Account> findAllAccounts() {
        String sql = "select * from accounts"
        jdbcTemplate.query(sql, accountMapper)
    }

    void updateAccount(Account account) {
        String sql = "update accounts set balance=? where id=?"
        jdbcTemplate.update(sql, account.balance, account.id)
    }

    void deleteAccount(int id) {
        String sql = "delete from accounts where id=?"
        jdbcTemplate.update(sql, id)
    }

    def accountMapper = { ResultSet rs, int row ->
        new Account(id: rs.getInt('id'),
                balance: rs.getBigDecimal('balance'))
    } as RowMapper<Account>
}
