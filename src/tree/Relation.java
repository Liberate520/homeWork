package tree;

import classes.Parent;

import java.util.ArrayList;

public interface Relation {
    FamilyTree familymembers = new FamilyTree();

    void addMember(RelationType type, Parent person);

    ArrayList<Parent> getMember(RelationType type);

    ArrayList<Parent> getChildren();

    void showMember(RelationType type);

    boolean checkMember(RelationType type);

    void showFamily();

    void showChildren();
}
