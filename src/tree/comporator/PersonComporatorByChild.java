package tree.comporator;
import java.util.Comparator;

import tree.person.Person;

public class PersonComporatorByChild implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o2.getChildrenList().size() == o1.getChildrenList().size()) {
            return 0;
        } else if (o1.getChildrenList().size() > o2.getChildrenList().size()) {
            return -1;
        }
        else{
            return 1;}
    }
}