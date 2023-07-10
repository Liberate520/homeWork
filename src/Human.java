import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(Gender gender, LocalDate birthDate, Human father, Human mother) {
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }
}