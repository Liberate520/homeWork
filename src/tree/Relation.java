package tree;

import classes.Person;

import java.util.ArrayList;

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

    void showChildren();
}
