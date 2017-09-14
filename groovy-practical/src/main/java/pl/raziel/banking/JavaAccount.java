package pl.raziel.banking;

import java.math.BigDecimal;

public class JavaAccount implements Account {
    private Integer id;
    private BigDecimal balance;

    public JavaAccount(Integer id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public double getBalance() {
        return balance.doubleValue();
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public double deposit(BigDecimal amount) {
        balance = balance.add(amount);
        return balance.doubleValue();
    }

    @Override
    public double withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
        return balance.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaAccount that = (JavaAccount) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return balance != null ? balance.equals(that.balance) : that.balance == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JavaAccount{");
        sb.append("id=").append(id);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
