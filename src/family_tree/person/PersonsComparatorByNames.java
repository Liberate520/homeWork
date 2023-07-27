package family_tree.person;

import java.util.Comparator;
public class PersonsComparatorByNames implements Comparator<Person> {
    @Override
    public int compare(Person sel1, Person sel2){
        return sel1.getName().compareTo(sel2.getName());
    }
}
