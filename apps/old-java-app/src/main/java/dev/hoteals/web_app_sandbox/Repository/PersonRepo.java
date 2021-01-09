package dev.hoteals.web_app_sandbox.Repository;


import dev.hoteals.web_app_sandbox.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Person> fetchAll()
    {
        String query = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(query, rowMapper);
    }

    public Person findPersonByID(int id)
    {
        String query = "SELECT * FROM person WHERE id = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person p = template.queryForObject(query, rowMapper, id);
        return p;
    }

    // in Cay's video, he provides data via postmapping annotation
    public Person addPerson(Person p)
    {
        String query = "INSERT INTO person(id, first_name, last_name) VALUES (?, ?, ?)";
        template.update(query, p.getId(), p.getFirstName(), p.getLastName());
        return null;
    }

    public Boolean updatePerson(Person p)
    {
        String query = "UPDATE person SET first_name = ?, last_name = ? WHERE id = ?";
        return template.update(query, p.getFirstName(), p.getLastName(), p.getId()) < 0;
    }

    public Boolean deletePerson(int id)
    {
        String query = "DELETE FROM person WHERE id = ?";
        return template.update(query, id) < 0;
    }
}
