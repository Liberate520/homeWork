package model.Organisms.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Serializable {
    private OrganismType organismType;
    private String name;
    private LocalDate birthDate;
    private  LocalDate deathDate;
    private  Sex sex;
    private  Person mother;
    private  Person father;
    public List<Person> children;
    public Person spouse;

    public Person(OrganismType type, String name, LocalDate birthDate, Sex sex, LocalDate deathDate,
                  Person mother, Person father, List<Person> children, Person spouse) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.spouse = spouse;
        this.organismType = type;
    }
    public Person(OrganismType type, String name, LocalDate birthDate, Sex sex){
        this(type, name, birthDate, sex, null, null, null, null, null);
    }

    public String getName (){
        return this.name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setChild (Person child){
        if (this.children == null) {
            this.children = new ArrayList<>();
            }
        if(!this.children.contains(child)) {
            this.children.add(child);
            if (this.sex.equals(Sex.male)){
                setFather(this, child);
            }else {
                setMother(this, child);
            }
            if(this.spouse != null){
                this.spouse.setChild(child);
            }
        }

    }
    private void setFather(Person father, Person child) {
        child.father = father;
    }
    private void setMother(Person mother, Person child) {
        child.mother = mother;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(organismType+" Name: "+name+"; Birthday: "+birthDate + "; Children: " + children);
        return sb.toString();
    }

    public void setSpouse(Person spouse){
        this.spouse = spouse;
    }


}
