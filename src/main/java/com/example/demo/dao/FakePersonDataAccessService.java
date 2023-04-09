package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements IPersonDAO{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int InsertPerson(UUID id, Person _person) {
        DB.add(new Person(id, _person.getName()));
        return 1;
    }

    @Override
    public List<Person> GetAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> GetPersonById(UUID id) {
        return DB.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
    }

    @Override
    public int UpdatePerson(UUID id, Person person) {
        return GetPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public void DeletePerson(UUID id) {
        Optional<Person> person = GetPersonById(id);
        DB.remove(person.get());
    }
    
}
