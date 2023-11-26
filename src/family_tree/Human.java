package family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private Genders gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;

    public Human(String firstName, String lastName, Genders gender, LocalDate birthDate,
                 LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.children = children;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human(String firstName, String lastName, Genders gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.mother = null;
        this.father = null;
        this.spouse = null;
        this.children = null;
    }

    public Human(String firstName, String lastName, Genders gender, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = null;
        this.father = null;
        this.spouse = null;
        this.children = null;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int age;
        ;
        boolean flag;
        sb.append("Персональная карточка: \n");
        sb.append(String.format("Имя, Фамилия: %s %s%n", this.firstName, this.lastName));
        sb.append(String.format("Пол: %s%n", this.gender));
        if (this.deathDate != null) {
            age = this.deathDate.getYear() - this.birthDate.getYear();
            sb.append(String.format("Дата рождения: %s%n", this.birthDate));
            sb.append("Дата смерти:" + this.deathDate + "\n");
            sb.append(String.format("Возраст: %d%n", age));

        } else {
            age = LocalDate.now().getYear() - this.birthDate.getYear();
            sb.append(String.format("Дата рождения: %s%n", this.birthDate));
            sb.append(String.format("Возраст: %d%n", age));
        }
        if (this.mother != null) {
            sb.append(String.format("Мать: %s%n", this.mother));
        }
        if (this.father != null) {
            sb.append(String.format("Отец: %s%n", this.father));
        }
        if (this.spouse != null) {
            sb.append(String.format("Супруг(а): %s%n", this.spouse));
        }
        if (this.children != null) {
            sb.append(String.format("Дети: %s%n", this.children));
        }

        return sb.toString();
    }


}
