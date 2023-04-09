package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPersonDAO;
import com.example.demo.model.Person;

@Service
public class PersonService {
    private IPersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDao") IPersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int InsertPerson(Person person){
        return personDAO.InsertPerson(person);
    }

    public List<Person> GetAllPerson(){
        return personDAO.GetAllPerson();
    }

    public Optional<Person> GetPersonById(UUID id){
        return personDAO.GetPersonById(id);
    }

    public int UpdatePerson(UUID id, Person person){
        return personDAO.UpdatePerson(id, person);
    }

    public void DeletePerson(UUID id){
        personDAO.DeletePerson(id);
    }

}
