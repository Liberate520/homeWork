package family_tree;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Human {
    private String name;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother,
            List<Human> children) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null, null);
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    private void addChildren(Human human) {
        children = new ArrayList<>();
        children.add(human);
    }

    private void addParents(Human human1, Human human2) {
        if (human1.gender == Gender.Male) {
            father = human1;
        } else {
            mother = human1;
        }
        if (human2.gender == Gender.Male) {
            father = human2;
        } else {
            mother = human2;
        }
    }

    public void createRelatings(Human human1, Human human2, Human human3) {
        human3.addParents(human1, human2);
        human1.addChildren(human3);
        human2.addChildren(human3);
    }

    private String getAllChildrens() {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append("\nСписок детей:\n");
        for (Human human : children) {
            stringBuilder.append(human.name);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + birthDate);
        if (deathDate != null) {
            stringBuilder.append(", Дата смерти: " + deathDate);
        }
        if (mother != null) {
            stringBuilder.append(", Мать: " + mother.name);
        }
        if (father != null) {
            stringBuilder.append(", Отец: " + father.name);
        }
        if (children != null) {
            stringBuilder.append("\nСписок детей " + name + ":\n");
            stringBuilder.append(getAllChildrens());
        }
        return stringBuilder.toString();
    }
}
