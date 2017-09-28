package pl.raziel.rest;

import java.util.List;

public interface PersonDAO {
    List<Person> findAll();

    Person findById(long id);

    List<Person> findByLastName(String name);

    Person create(Person person);

    Person update(Person person);

    boolean delete(long id);
}
