package family_tree.model.humans;

import java.time.LocalDate;

import family_tree.model.human_family.FamilyTree;
import family_tree.model.human_family.HumanItem;

public class Human<T extends HumanItem<T>> {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private FamilyTree<T> familyTree;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.familyTree = new FamilyTree<>();

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

    public void addChild(T human) {
        familyTree.addChild(human);
    }

    public void addParent(T human) {
        familyTree.addParent(human);
    }

}
