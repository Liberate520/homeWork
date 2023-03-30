
import java.util.List;
import java.util.ArrayList;

public class Human {
    private String fullName;
    private Gender gender;
    private Human father;
    private Human mother;
    private int birthYear;
    private List<Human> children;

    public Human(String fullName, Gender gender, Human father, Human mother, int birthYear, ArrayList<Human> children) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthYear = birthYear;
        this.children = children;
    }

    public Human(String fullName, Gender gender, Human father, Human mother, int birthYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public Human(String fullName, Gender gender, int birthYear, ArrayList<Human> children) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.birthYear = birthYear;
        this.children = children;
    }

    public Human(String fullName, Gender gender, int birthYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Полное имя: %s (%d)\n ", this.fullName, this.birthYear);
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setFather(Human father) {
        if (this.gender.equals(gender.male)) {
            this.father = father;
        } else {
            System.out.println("Ошибка! Проверьте пол отца!");
        }
    }

    public void setMother(Human mother) {
        if (this.gender.equals(gender.female)) {
            this.father = mother;
        } else {
            System.out.println("Ошибка! Проверьте пол матери!");
        }
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    /*public void addChild(Human child) {
        int ageParentMin = 18;
        if (child.getBirthYear() > this.getBirthYear() + ageParentMin) {
            this.children.add(child);
        } else {
            System.out.printf("Ошибка!!! Родители не могут быть моложе %s лет \n", ageParentMin);
        }
    }*/
}
