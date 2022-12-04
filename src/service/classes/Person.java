package service.classes;

import service.tree.FamilyTree;
import service.tree.Relation;

import java.io.Serializable;
import java.util.ArrayList;

import static service.tree.RelationType.DAUGHTER;
import static service.tree.RelationType.SON;

public class Person extends Human implements Relation, Serializable {

    private final FamilyTree familymembers;

    public Person(Human human, FamilyTree familymembers) {
        this.name = human.name;
        this.familyname = human.familyname;
        this.gender = human.gender;
        this.marigeStatus = human.marigeStatus;
        this.familymembers = familymembers;
    }

    public Person(Human human) {
        this(human, new FamilyTree());
    }

    public Person() {
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

    public ArrayList<Person> getChildren() {
        ArrayList<Person> children = new ArrayList<>();
        try {
            ArrayList<Person> sons = new ArrayList<>(this.getMember(SON));
            children.addAll(sons);
        } catch (Exception ignored) {
        }

        try {
            ArrayList<Person> daughters = new ArrayList<>(this.getMember(DAUGHTER));
            children.addAll(daughters);
        } catch (Exception ignored) {
        }

        return children;
    }

    public int getChildrenCount(){
        return getChildren().size();
    }
}
