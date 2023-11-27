import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human mother, father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void addChildren(Human human) {
        children.add(human);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Birth Date: " + birthDate
                + ", Death Date: " + deathDate + ", Mother: " + mother +
                ", Father: " + father;
    }

    public String getChildrenInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей:\n");
        for (Human human : children) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }
}