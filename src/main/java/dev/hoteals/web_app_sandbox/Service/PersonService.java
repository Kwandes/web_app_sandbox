package dev.hoteals.web_app_sandbox.Service;

import dev.hoteals.web_app_sandbox.Model.Person;
import dev.hoteals.web_app_sandbox.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService
{
    @Autowired
    PersonRepo personRepo;

    public List<Person> fetchAll()
    {
        //SQL code
        return personRepo.fetchAll();
    }

    public Person findPersonByID(int id)
    {
        return personRepo.findPersonByID(id);
    }

    public Person addPerson(Person p)
    {
        return personRepo.addPerson(p);
    }

    public Boolean updatePerson(Person p)
    {
        return personRepo.updatePerson(p);
    }

    public Boolean deletePerson(int id)
    {
        return personRepo.deletePerson(id);
    }
}
