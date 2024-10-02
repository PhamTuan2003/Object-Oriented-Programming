package com.vds.huylq33.service;

import com.vds.huylq33.model.Person;
import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person get(int id);

    void add(Person person);

    void update(Person person);

    void delete(int id);

    int createPerson(String name);
}
