package model.Organisms.Human;

import model.Organisms.Person.Person;
import model.Organisms.Person.Sex;
import model.Organisms.Person.OrganismType;

import java.time.LocalDate;
import java.util.List;

public class Human extends Person {
    private OrganismType type;
    private String name;
    private LocalDate birthDate;
    private  LocalDate deathDate;
    private  Sex sex;
    private  Person mother;
    private  Person father;
    public List<Person> children;
    public Person spouse;
    public Human(OrganismType type, String name, LocalDate birthDate, Sex sex){
        super(type, name, birthDate, sex, null, null, null, null, null);
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


    public void setChild(Human child) {
        super.setChild(child);
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
