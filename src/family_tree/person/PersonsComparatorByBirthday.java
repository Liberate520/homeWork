package family_tree.person;

import java.util.Comparator;
public class PersonsComparatorByBirthday<P extends Person> implements Comparator<P> {
    @Override
    public int compare(P sel1, P sel2){
        return sel1.getBirthData().compareTo(sel2.getBirthData());
    }
}
