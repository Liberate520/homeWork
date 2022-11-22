package classes;

import java.util.ArrayList;

import tree.FamilyTree;

public class Parent extends Human {

    private FamilyTree children;

    public Parent(Human human) {
        this.name = human.name;
        this.familyname = human.familyname;
        this.gender = human.gender;
        this.marigeStatus = human.marigeStatus;
        this.children = new FamilyTree();
        this.parents = human.getParents();
    }

    public Parent(){
        this(new Human());
    }

    public void addChild(Parent child) {
        children.addMember(child);
    }

    public void showChildren() {
        for (Human child : children.getTree()) {
            child.getInfo();
        }
    }

    public ArrayList<Parent> getChildren() {
        return this.children.getTree();
    }

    public void replaceChild(Parent old, Parent newOne) {
        this.children.replace(old, newOne);
    }
}
