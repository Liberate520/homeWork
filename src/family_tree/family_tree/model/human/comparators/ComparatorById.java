package family_tree.family_tree.model.human.comparators;

import family_tree.family_tree.model.GeneralTypeTree;

import java.util.Comparator;

public class ComparatorById<G extends GeneralTypeTree<G>> implements Comparator<G> {
    @Override
    public int compare(G o1, G o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
