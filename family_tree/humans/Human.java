package family_tree.humans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import family_tree.human_family.HumanItem;

public class Human<T> implements Serializable, HumanItem {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<T> parents;
    private List<T> children;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", birthdate=" + birthDate + ", gender=" + gender + '}';
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
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

    public List<T> getParents() {
        return parents;
    }

    public List<T> getChildren() {
        return children;
    }

    public void addParent(T parent) {
        this.parents.add(parent);
    }

    public void addChild(T child) {
        this.children.add(child);
    }

    @Override
    public List<T> getAllChildren() {
        System.out.println("maksim's children:");
        for (T child : children) {
            System.out.println(((HumanItem) child).getName());
    }
    return children;
}
}
