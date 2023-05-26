package homeWork.tree;

import java.util.ArrayList;

public class FamilyTree {
    private static ArrayList<Human> people;
    private static ArrayList<Parent> parents;
    private static ArrayList<Child> children;

    public static ArrayList<Human> getPeople() {
        people = Generation.generateFamily();
        return people;
    }

    public static ArrayList<Parent> getParents() {
        parents = Generation.generateParents();
        return parents;
    }

    public static ArrayList<Child> getChildren() {
        children = Generation.generateChildren();
        return children;
    }

    public void setPeople(ArrayList<Human> people) {
        this.people = people;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public ArrayList<Human> showPeople() {
        return people;
    }

    public ArrayList<Parent> showParents() {
        return parents;
    }

    public ArrayList<Child> showChildren() {
        return children;
    }

    public ArrayList<Human> theChildrenOfOnePeople(Parent parent){
        return parent.getChildren();
    }

    public ArrayList<Human> theParentsOfOnePeople(Child child){
        return child.getParents();
    }


}
