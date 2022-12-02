package service.tree;

import service.classes.Person;

import java.util.ArrayList;
import java.util.HashMap;

public interface Relation {
    default void addMember(RelationType type, Person person) {
        getTree().addMember(type, person);
    }

    FamilyTree getTree();

    default ArrayList<Person> getMember(RelationType type) {

        return getTree().getMember(type);
    }

    ArrayList<Person> getChildren();

    default void showMember(RelationType type) {
        getTree().showMember(type);
    }

    default boolean checkMember(RelationType type) {
        return getTree().checkMember(type);
    }

    default void showFamily() {
        getTree().showTree();
    }

    default HashMap<RelationType, ArrayList<Person>> getFamily() {
        return getTree().getTree();
    }

    void showChildren();
}
