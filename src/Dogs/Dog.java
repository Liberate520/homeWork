package Dogs;

import Person.Person;
import Person.Sex;
import java.time.LocalDate;
import java.util.List;

public class Dog extends Person {
    private String name;
    private LocalDate birthDate;
    private  LocalDate deathDate;
    private  Sex sex;
    private  Person mother;
    private  Person father;
    public List<Person> children;
    public Person spouse;
    public Dog(String name, LocalDate birthDate, Sex sex){
        super(name, birthDate, sex, null, null, null, null, null);
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
