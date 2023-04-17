package model.Persons;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Person implements InterfacePerson
{
    private int id;
    private Person father;
    private Person mother;
    private Gender gender;
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private LocalDate dataDeath;
    private ArrayList<Person> children;
    


    public Person(int id, String lastName, String firstName, Gender gender,
    LocalDate dataBirth, LocalDate dataDeath, Person father, Person mother, ArrayList<Person> children)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dataBirth = dataBirth;
        this.dataDeath = dataDeath;
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.dataBirth = dataBirth;
        this.dataDeath = dataDeath;
    }    
    
    public Person()
    {
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setFather(Person father)
    {
        this.father = father;
    }

    public Person getFather() 
    {
        return father;
    }
    public void setMother(Person mother) 
    {
        this.mother = mother;
    }
    public Person getMother() 
    {
        return mother;
    }

    public void setGender(Gender gender) 
    {
        this.gender = gender;
    }
    public Gender getGender() 
    {
        return gender;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    public String getLastName() 
    {
        return lastName;
    }

    public void setDataBirth(LocalDate dataBirth) 
    {
        this.dataBirth = dataBirth;
    }
    public LocalDate getDataBirth() 
    {
        return dataBirth;
    }
    public void setDataDeath(LocalDate dataDeath) 
    {
        this.dataDeath = dataDeath;
    }
    public LocalDate getDataDeath() {
        return dataDeath;
    }
    
    public void setChildren(ArrayList<Person> children) 
    {
        this.children = children;
    }
    public ArrayList<Person> getChildren()
    {
        return children;
    }

    public void addChildren(Person person)
    {
        if(this.children == null)
        {
            this.children = new ArrayList<>();    
        }
        this.children.add(person);
    }

    public int getAge() 
    {
        LocalDate currenDate = LocalDate.now();
        if (getDataDeath() == null)
            return Period.between(dataBirth, currenDate).getYears();
        else
            return Period.between(dataBirth, dataDeath).getYears();
    }

    
}
