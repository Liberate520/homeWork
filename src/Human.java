package familyTree.src;

import java.util.*;
public class human {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Lst<Human> parents;
    private List<Human> children;
    //TODO добавить супруга
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        this(name, gender, birthDate, null, father, mother);
    }

}
