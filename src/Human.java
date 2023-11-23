import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String familyName;
    private Gender gender;
    private String  birthData;
    private String deathData;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(String name, String familyName, Gender gender, String birthData) {
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.birthData = birthData;
        this.childrens = new ArrayList<>();
    }

    public Human(String name, String familyName, Gender gender, String birthData, Human mother, Human father) {
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.birthData = birthData;
        this.childrens = new ArrayList<>();
        if (mother.getGender().equals(Gender.female)) {
            this.mother = mother;
            mother.childrens.add(this);
        }
        if (father.getGender().equals(Gender.male)) {
            this.father = father;
            father.childrens.add(this);
        }

    }

    @Override
    public String toString() {
        return name + " " + familyName + " ";
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildrens() {
        return childrens;
    }


}

