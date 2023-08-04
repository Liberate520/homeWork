package model.Organisms.Dogs;

import model.Organisms.Person.Person;
import model.Organisms.Person.Sex;
import model.Organisms.Person.OrganismType;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Person {
    private OrganismType type;
    private String name;
    private LocalDate birthDate;
    private  LocalDate deathDate;
    private  Sex sex;
    private  Person mother;
    private  Person father;
    public List<Person> children;
    public Person spouse;
    public Dog(OrganismType organismType, String name, LocalDate birthDate, Sex sex){
        super(organismType, name, birthDate, sex, null, null, null, null, null);
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.spouse = spouse;
    }

    public String getName (){
        return name;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
