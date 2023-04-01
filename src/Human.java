import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс человека
 */
public class Human {
    private Gender gender;
    private String name;
    private String surname;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(Gender gender, String name, String surname, LocalDate dateBirth, LocalDate dateDeath) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
    }

    public Human(Gender gender, String name, String surname, LocalDate dateBirth) {
        this(gender, name, surname, dateBirth, null);
    }

    public Human() {
        this(Gender.indefinite, "", "", null, null);
    }


    // getter
    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    public void setFather(Human father) {
        this.father = father;
        if (father != null) {
            father.addChild(this);
        }
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (mother != null) {
            mother.addChild(this);
        }
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    /**
     * Метод добавляет ребенка в список детей родителя
     */
    public void addChild(Human child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s%s)", this.name, this.surname, this.dateBirth, this.dateDeath == null ? "" : " - " + this.dateDeath);
    }
}
