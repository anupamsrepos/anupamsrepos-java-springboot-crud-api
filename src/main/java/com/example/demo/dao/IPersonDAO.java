package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface IPersonDAO {
    int InsertPerson(UUID id, Person _person);
    
    default int InsertPerson(Person _person){
        UUID uuid = UUID.randomUUID();
        return InsertPerson(uuid, _person);
    }

    List<Person> GetAllPerson();

    Optional<Person> GetPersonById(UUID id);

    int UpdatePerson(UUID id, Person person);

    void DeletePerson(UUID id);
}
