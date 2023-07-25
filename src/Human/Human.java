package Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import family_tree.Gender;

public class Human {
    long id;
    String name;
    Gender gender;
    LocalDate birthDate;
    LocalDate deathDate;
    List<Human> parents;
    List<Human> children;
    
        
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Person mother, Person Father, Person children ){
        id = 1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();// add mother father
        children = new ArrayList<>(); // add children

    }

    /*
     * методы
     * getAge
     * addParents
     * addMother
     * addFather
     * addChildren
     * 
     * toString
     */



}
