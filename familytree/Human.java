package homeWork.familytree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;



    // Constructor
    public Human(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    // Other methods and getters/setters...
}



