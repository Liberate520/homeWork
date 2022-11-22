package classes;

import java.util.ArrayList;

import tree.FamilyTree;
import tree.Relation;
import tree.RelationType;

import static tree.RelationType.*;

public class Parent extends Human implements Relation {

    private FamilyTree familymembers;

    public Parent(Human human, FamilyTree familymembers) {
        this.name = human.name;
        this.familyname = human.familyname;
        this.gender = human.gender;
        this.marigeStatus = human.marigeStatus;
        this.familymembers = familymembers;
    }

    public Parent(Human human) {
        this(human, new FamilyTree());
    }

    public Parent() {
        this(new Human());
    }

    public void addMember(RelationType type, Parent person) {
        this.familymembers.addMember(type, person);
    }

    @Override
    public ArrayList<Parent> getMember(RelationType type) {
        return this.familymembers.getMember(type);
    }


    public void showChildren() {
        for (Parent child : this.getChildren()) {
            child.getInfo();
        }
    }

    public void showMember(RelationType type){
        this.familymembers.showMember(type);
    }

    public boolean checkMember(RelationType type){
        return this.familymembers.checkMember(type);
    }

    @Override
    public void showFamily() {
        this.familymembers.showTree();
    }

    public ArrayList<Parent> getChildren() {
        ArrayList<Parent> children = new ArrayList<>();
        try {
            ArrayList<Parent> sons = new ArrayList<>(this.getMember(SON));
            children.addAll(sons);
        } catch (Exception ignored) {
        }

        try {
            ArrayList<Parent> daughters = new ArrayList<>(this.getMember(DAUGHTER));
            children.addAll(daughters);
        } catch (Exception ignored) {
        }

        return children;
    }
}
