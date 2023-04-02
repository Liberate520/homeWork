import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Integer birthAge;
    private Human mother;
    private Human father;
    private Human child;
    private List<Human> childList;
    private List<Human> parentList;

    public Human(String name, Gender gender, Integer birthAge) {
        this.name = name;
        this.gender = gender;
        this.birthAge = birthAge;
        this.childList = new ArrayList<>();
        this.parentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFather(Human father) {
        this.father = father;
        father.addChild(this);
    }

    public void addMother(Human mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public void addChild(Human child) {
        childList.add(child);
        if (this.gender == Gender.Male) {
            child.setFather(this);
        } else {
            child.setMother(this);
        }
    }

    public void setFather(Human father) {
        this.father = father;
        parentList.add(father);
    }

    public void setMother(Human mother) {
        this.mother = mother;
        parentList.add(mother);
    }

    @Override
    public String toString() {
        return name + ", пол: " + gender + ", год рождения: " + birthAge;
    }

}
