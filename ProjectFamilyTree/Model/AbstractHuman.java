package homeWork.ProjectFamilyTree.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHuman {
    private int humanId;
    private String name;
    private Human mother, father;
    private List<Human> children;
    private List<Human> sibling;
    private LocalDate localDateOfBirth;
    private LocalDate localDateofDeath;

    private Gender gender;

    public AbstractHuman(String name, Human mother, Human father, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        sibling = new ArrayList<>();
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = localDateofDeath;
        this.gender = gender;
    }
    protected AbstractHuman() {
    }
}
