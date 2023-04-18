import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private String dob;
    private Human mother;
    private Human father;
    private List<Human> childrens = new ArrayList<>();


    public Human(String firstName, String lastName, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null) return false;
//        if (!(obj instanceof Human human)) return false;
//        return firstName.equals(human.firstName) &&
//                lastName.equals(human.lastName) &&
//                dob.equals(human.dob);
//    }

    public void addChildren(Human human) {
        childrens.add(human);
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildrens(List<Human> childrens) {
        this.childrens = childrens;
    }

    public Human getFather() { return father; }

    public Human getMother() { return mother; }

    public List<Human> getChildren() { return childrens; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFull() {
        return firstName + lastName + dob;
    }

    public String toSting() {
        return "Human[" + getFullName() + "]";
    }
}
