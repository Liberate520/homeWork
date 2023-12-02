package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable, Humans {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    //TODO: Переделать в конструктор
    private List<Human> children;
    boolean inTree = false;

    public Human() {
        this.children = new ArrayList<Human>();
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate birthDate,
                 LocalDate deathDate, Human mother, Human father, Human spouse) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        //TODO: Добавить список бывших супругов - должны добавляться при разводе
        //TODO: Добавить уникальный автоматический ID каждому человеку и завязать на него equals
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this(firstName, lastName, gender, birthDate, null, null,
                null, null);
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, gender, birthDate, deathDate, null, null, null);
    }

    public Human(String firstName, String lastName, Gender gender, Human mother, Human father) {
        this(firstName, lastName, gender, null, null, mother, father, null);
    }

    boolean setMother(Human mother) {
        if (this.mother != null) {
            System.out.println("Мать уже задана");
            return false;
        } else {
            this.mother = mother;
            return true;
        }

    }

    boolean setFather(Human father) {
        if (this.father != null) {
            System.out.println("Отец уже задан");
            return false;
        } else {
            this.father = father;
            return true;
        }
    }

    boolean setSpouse(Human spouse) {
        if (this.spouse != null) {
            System.out.println("Супруг уже задан");
            return false;
        } else {
            this.spouse = spouse;
            return true;
        }
    }

    public void setChildren(Human child) {
        if (this.children != null) {
            for (Human child1 : children) {
                if (child1.equals(child)) {
                    System.out.println("Такой ребенок уже задан");
                    return;
                }
            }
        }
        this.children.add(child);
    }

    public void setInTree(boolean inTree) {
        this.inTree = inTree;
    }

    LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return firstName + " " + lastName;
    }


    Human getSpouse() {
        return spouse;
    }

    Human getMother() {
        return mother;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - this.getBirthDate().getYear();
    }

    Human getFather() {
        return father;
    }

    List<Human> getChildren() {
        return children;
    }

    public boolean isInTree() {
        return inTree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int age;
        boolean flag = false;
        sb.append("Персональная карточка: \n");
        sb.append(String.format("Имя, Фамилия: %s %s%n", this.firstName, this.lastName));
        if (this.gender.equals(Gender.Male)) {
            sb.append("Пол: Мужской\n");
        } else {
            sb.append("Пол: Женский\n");
        }

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
            sb.append(String.format("Мать: %s%n", this.mother.getName()));
        }
        if (this.father != null) {
            sb.append(String.format("Отец: %s%n", this.father.getName()));
        }
        if (this.spouse != null) {
            sb.append(String.format("Супруг(а): %s%n", this.spouse.getName()));
        }
        if (this.children != null) {
            sb.append("Дети: ");
            for (Human child : this.children) {
                if (flag) sb.append(", ");
                sb.append(child.getName());
                flag = true;
            }

        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(this.hashCode(), human.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, birthDate);
    }


    @Override
    public int compareTo(Object o) {
        return new HumanComporatorByName().compare(this, (Humans) o);
    }
}
