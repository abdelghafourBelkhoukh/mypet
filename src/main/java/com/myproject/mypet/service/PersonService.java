package com.myproject.mypet.service;

import com.myproject.mypet.model.Person;
import com.myproject.mypet.repo.PersonResository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {
    private final PersonResository personResository;

//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public PersonService(PersonResository personResository) {
        this.personResository = personResository;
    }

    public Person addPerson(Person person) {
//        person.setEmail(UUID.randomUUID().toString());
        return personResository.save(person);
    }

    public List<Person> findAllPersons() {
        return personResository.findAll();
    }

    public Person findPersonById(Long id) {
        return personResository.findPersonById(id)
                .orElseThrow();
    }

    public Person updatePerson(Person person) {
        return personResository.save(person);
    }

    public void deletePerson(Long id) {
        personResository.deleteById(id);
    }

    public Person findUserByEmail(String email) {
        return personResository.findPersonByEmail(email)
                .orElseThrow();

    }
}
