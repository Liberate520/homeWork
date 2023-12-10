package family_tree.family_tree.model.human.comparators;

import family_tree.family_tree.model.GeneralTypeTree;

import java.util.Comparator;

public class ComparatorByName<G extends GeneralTypeTree> implements Comparator<G> {
    @Override
    public int compare(G o1, G o2){
        return o1.getName().compareTo(o2.getName());
    }
}
