package family_tree.person;

import java.util.Comparator;
public class PersonsComparatorByNames<P extends Person> implements Comparator<P> {
    @Override
    public int compare(P sel1, P sel2){
        return sel1.getName().compareTo(sel2.getName());
    }
}
