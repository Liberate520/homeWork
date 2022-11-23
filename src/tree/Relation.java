package tree;

import classes.Parent;

import java.util.ArrayList;

public interface Relation {
    default void addMember(RelationType type, Parent person) {
        getTree().addMember(type, person);
    }

    FamilyTree getTree();

    default ArrayList<Parent> getMember(RelationType type) {

        return getTree().getMember(type);
    }

    ArrayList<Parent> getChildren();

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
