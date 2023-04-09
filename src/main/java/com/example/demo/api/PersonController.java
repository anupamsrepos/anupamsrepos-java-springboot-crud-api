package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import io.micrometer.common.lang.NonNull;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void InsertPerson(@Validated @NonNull @RequestBody Person person){
        personService.InsertPerson(person);
    }

    @GetMapping
    public List<Person> GetAllPerson(){
        return personService.GetAllPerson();
    }

    @GetMapping(path = "/{id}")
    public Person GetPersonById(@PathVariable("id") UUID id){
        return personService.GetPersonById(id)
        .orElse(null);
    }

    @PutMapping(path = "/{id}")
    public int UpdatePerson(@PathVariable("id") UUID id, @NonNull @Validated @RequestBody Person person){
        return personService.UpdatePerson(id, person);
    }

    @DeleteMapping(path = "/{id}")
    public void DeletePerson(@PathVariable("id") UUID id){
        personService.DeletePerson(id);
    }
}
