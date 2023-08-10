package family_tree.backend.person;

import family_tree.backend.ftree.Relatives;

import java.util.Comparator;
public class PersonsComparatorByNames<T extends Relatives> implements Comparator<T> {
    @Override
    public int compare(T sel1, T sel2){
        return sel1.getLFName().compareTo(sel2.getLFName());
    }
}
