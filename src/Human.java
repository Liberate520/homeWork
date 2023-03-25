import java.util.ArrayList;
import java.util.List;

public class Human {
    private String fio;
    private int yearBirth;
    private int yearDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children=new ArrayList<>();

    public Human(int yearBirth,int yearDeath, String fio,Gender gender, Human father, Human mother) {
        this.fio = fio;
        this.yearBirth = yearBirth;
        this.yearDeath = yearDeath;
        this.father = father;
        this.mother = mother;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
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

    public void setChildren(Human children) {
        this.children.add(children);
    }
    public void setChildren(List<Human> children) {
        this.children.addAll(children);
    }
    public int getYearDeath() {
        return yearDeath;
    }

    public void setYearDeath(int yearDeath) {
        this.yearDeath = yearDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return fio;
    }
}
