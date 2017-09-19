package pl.raziel.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.raziel.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
