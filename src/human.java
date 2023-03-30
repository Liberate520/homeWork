
import java.util.List;
import java.util.ArrayList;

public class human {
    private String fullName;
    private gender gender;
    private human father;
    private human mother;
    private int birthYear;
    private List<human> children;

    public human(String fullName, gender gender, human father, human mother, int birthYear, ArrayList<human> children) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthYear = birthYear;
        this.children = children;
    }

    public human(String fullName, gender gender, human father, human mother, int birthYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public human(String fullName, gender gender, int birthYear, ArrayList<human> children) {
        this.fullName = fullName;
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.birthYear = birthYear;
        this.children = children;
    }

    public human(String fullName, gender gender, int birthYear) {
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

    public gender getGender() {
        return gender;
    }

    public human getFather() {
        return father;
    }

    public human getMother() {
        return mother;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public List<human> getChildren() {
        return children;
    }

    public void setFather(human father) {
        if (this.gender.equals(gender.male)) {
            this.father = father;
        } else {
            System.out.println("Ошибка! Проверьте пол отца!");
        }
    }

    public void setMother(human mother) {
        if (this.gender.equals(gender.female)) {
            this.father = mother;
        } else {
            System.out.println("Ошибка! Проверьте пол матери!");
        }
    }

    public void setChildren(List<human> children) {
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
