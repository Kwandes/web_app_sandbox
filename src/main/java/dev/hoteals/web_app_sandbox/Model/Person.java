package dev.hoteals.web_app_sandbox.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person
{
    @Id
    private int id;
    private String firstName;
    private String lastName;

    public Person()
    {
    }

    public Person(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //region Getters and Setters

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    //endregion
}
