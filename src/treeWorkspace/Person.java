package treeWorkspace;

import enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private int age;
    private List<Person> parentsList;
    private List<Person> childrenList;

    public Person(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    public Person(int id,String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate);
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void addDeathDate(LocalDate deathDate){
        this.deathDate = deathDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", age=" + age +
                ", parentsList=" + parentsList +
                ", childrenList=" + childrenList +
                '}';
    }
}
