package Model;

import java.util.ArrayList;
import java.util.List;

public class Child extends Human implements JuniorKinsman<Parent, Child> {
    private Parent mother;
    private Parent father;
    public Child(boolean sex, int age, String firstName, String lastName) {
        super(sex, age, firstName, lastName);
    }
    public Parent getMother() {
        return mother;
    }
    public Parent getFather() {
        return father;
    }
    public void setMother(Parent mother) {
        this.mother = mother;
    }
    public void setFather(Parent father) {
        this.father = father;
    }
    public void whoYourFather() {
        whoYourParents(Human.male);
    }
    public void whoYourMother() {
        whoYourParents(Human.female);
    }
    private String getParentString(boolean sex) {
        return sex == male ? "father" : "mother";
    }
    private void whoYourParents(boolean sex) {
        String parentString = getParentString(sex);
        if ((father == null && sex == Human.male) || (mother == null && sex == Human.female))
            System.out.println("I have no " + parentString);
        else
            System.out.format("My %s is %s\n", parentString, sex == male ? father : mother);
    }

    public Parent BecomeSenior(Child child) {
        List<Child> children = new ArrayList<>();
        children.add(child);
        return new Parent(this.getSex(), this.getAge(), this.getFirstName(), this.getLastName(), children);
    }

    public Parent BecomeParent(Child child) {
        return BecomeSenior(child);
    }
}
