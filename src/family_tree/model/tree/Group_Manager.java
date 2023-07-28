package family_tree.model.tree;

import family_tree.model.human.Child_type;
import family_tree.model.human.Parent_Type;

public interface Group_Manager<E extends SentientEntity<E>> {

    void addParent(E child, E parent, Parent_Type parentType);

    void addChild(E child, E parent, Child_type childType);

    boolean wedding(E husband, E wife);

    boolean divorce(E husband, E wife);
}
