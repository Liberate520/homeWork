package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Human> parents;
    private List<Human> children;
    private List<Human> allPeople;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        allPeople.add(this);
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getAllPeople() {
        return allPeople;
    }

    public String getName() {
        return name;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren(){
        return children;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public void addChild(Human child) {
        this.children.add(child);
    }
}
