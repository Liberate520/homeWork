import java.io.Serializable;
import java.util.ArrayList;

public class Human implements Serializable{
    private String name;
    private String surname;
    private Sex sex;
    private String startDate;
    private String endDate;
    private Human father;
    private Human mother;
    private ArrayList<Human> children;

    public Human(String name, String surname, Sex sex, String startDate, String endDate, Human father, Human mother,
            ArrayList<Human> children) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.startDate = startDate;
        this.endDate = endDate;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human(String name, String surname, Sex sex, String startDate, String endDate, Human father, Human mother) {
        this(name, surname, sex, startDate, endDate, father, mother, new ArrayList<Human>());
    }

    public Human(String name, String surname, Sex sex, String startDate, String endDate) {
        this(name, surname, sex, startDate, endDate, null, null);
    }

    public Human(String name, String surname, Sex sex, String startDate) {
        this(name, surname, sex, startDate, null);
    }

    @Override
    public String toString() {
        return "Human name: " + name + " " + surname + ", Date = " + startDate + " - " + endDate + " ," + " father: "
                + getNameFather() + " mother: " + getNameMother() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        var t = (Human) obj;
        return this.getSurname() == t.getSurname() && this.getName() == t.getName()
                && this.getStartDate() == t.getStartDate() && this.getEndDate() == t.getEndDate();
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        children.add(child);
        if (this.sex == Sex.Male){
            child.setFather(this);
        } else {
            child.setMother(this);
        }
        
    }

    private String getNameFather() {
        if (father != null) {
            return father.getName();
        }
        return "null";
    }

    private String getNameMother() {
        if (mother != null) {
            return mother.getName();
        }
        return "null";
    }

}
