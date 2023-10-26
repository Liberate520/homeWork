package family_tree;

import java.time.LocalDate;
import java.util.*;

public class Human {
    private int id;
    String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Formation formation;
    private Human father;
    private Human mother;
//    private List<Human> children;

    boolean parents;
    String secondparent;
    int child;
    Human[] children;
    public Human(String name){
        this.name = name;
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother, Formation formation ) {
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.formation = formation;
//        children = new ArrayList<>();
    }

    public Human(String name, boolean parents, String secondparent, Human[] children, int child) {
        this.name = name;
        this.parents = parents;
        this.secondparent = secondparent;
        this.children = children;
        this.child = child;
    }
    public Human(String name , boolean parents, String secondparent) {
        this.name = name;
        this.parents = parents;
        this.secondparent = secondparent;
    }


}
