package family_tree.person;

import java.util.Comparator;
public class PersonsComparatorByBirthday implements Comparator<Person> {
    @Override
    public int compare(Person sel1, Person sel2){
        return sel1.getBirthData().compareTo(sel2.getBirthData());
    }
}
