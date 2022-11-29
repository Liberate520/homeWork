package classes;

import tree.FamilyTree;
import tree.Relation;

import java.io.Serializable;
import java.util.ArrayList;

import static tree.RelationType.DAUGHTER;
import static tree.RelationType.SON;

public class Parent extends Human implements Relation, Serializable {

    private final FamilyTree familymembers;

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

    public FamilyTree getTree() {
        return this.familymembers;
    }

    public void showChildren() {
        if (this.checkMember(SON)) {
            this.showMember(SON);
        } else {
            System.out.println("No sons found.");
        }
        if (this.checkMember(DAUGHTER)) {
            this.showMember(DAUGHTER);
        } else {
            System.out.println("No daughters found.");
        }
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

    public int getChildrenCount(){
        return getChildren().size();
    }
}
