package service.tree;

import service.classes.Person;

import java.util.ArrayList;
import java.util.HashMap;

/*
Интерфейс для работы с объектами семейного дерева
 */
public interface Relation {
    default void addMember(RelationType type, Person person) {
        getTree().addMember(type, person.getDbIndex());
    }

    FamilyTree getTree();

    default ArrayList<Integer> getMember(RelationType type) {
        return getTree().getMember(type);
    }

    ArrayList<Integer> getChildren();

    default void showMember(RelationType type) {
        getTree().showMember(type);
    }

    default boolean checkMember(RelationType type) {
        return getTree().checkMember(type);
    }

    default void showFamily() {
        getTree().showTree();
    }

    default HashMap<RelationType, ArrayList<Integer>> getFamily() {
        return getTree().getTree();
    }

    void showChildren();
}
