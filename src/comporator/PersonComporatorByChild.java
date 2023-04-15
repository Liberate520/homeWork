package comporator;
import person.Person;

import java.util.Comparator;

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