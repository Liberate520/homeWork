package Model;

import java.util.ArrayList;
import java.util.List;
public class Parent extends Human implements SeniorKinsman<Child> {
    private List<Child> children;
    public List<Child> getChildren() {
        return children;
    }
    public Parent setChildren(List<Child> children) {
        this.children = children;
        setParent(children);
        return  this;
    }
    public Parent setChild(Child child) {
        if (children == null){
            List<Child> list = new ArrayList<>();
            list.add(child);
            this.children = list;
        }
        else children.add(child);
        setParent(child);
        return  this;
    }
    public Parent setSex(boolean sex) {
        super.setSex(sex);
        return this;
    }
    public Parent setAge(int age) {
        super.setAge(age);
        return this;
    }
    public Parent setFirstName(String firstName) {
        super.setFirstName(firstName);
        return this;
    }
    public Parent setLastName(String lastName) {
        super.setLastName(lastName);
        return this;
    }
    public Parent(boolean sex, int age, String firstName, String lastName, List<Child> children) {
        super(sex, age, firstName, lastName);
        createRelationship(children);
    }
    public Parent() {
        super();
    }
    public void whoYourChildren() {
        if (children == null) System.out.println("I have no children");
        else {
            for (Child child : children) {
                System.out.println((child.getSex() == Human.male ? "boy: " : "girl: ") + child);
            }
        }
    }
    public void setParent(Child child)
    {
        if (child != null){
                if (getSex() == male) child.setFather(this);
                else child.setMother(this);
            }
    }

    private void setParent(List<Child> children)
    {
        if (children != null)
            for (Child child: children) {
                if (getSex() == male) child.setFather(this);
                else child.setMother(this);
            }
    }

    @Override
    public void setSeniorFor(List<Child> children) {
        setParent(children);
    }

    @Override
    public void setLinkTo(List<Child> children) {
        this.children  = children;
    }
}
