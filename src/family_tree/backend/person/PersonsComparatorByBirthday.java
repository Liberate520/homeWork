package family_tree.backend.person;

import family_tree.backend.ftree.Relatives;

import java.util.Comparator;
public class PersonsComparatorByBirthday<T extends Relatives<T>> implements Comparator<T> {
    @Override
    public int compare(T sel1, T sel2){
        return sel1.getBirthData().compareTo(sel2.getBirthData());
    }
}
