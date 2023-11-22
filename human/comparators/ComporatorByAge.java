package family_tree.human.comparators;

import family_tree.family_tree.GeneralTypeTree;

import java.util.Comparator;

public class ComporatorByAge<G extends GeneralTypeTree> implements Comparator<G> {
    @Override
    public int compare(G o1, G o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
