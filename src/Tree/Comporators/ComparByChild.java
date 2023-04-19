package Tree.Comporators;
import java.util.Comparator;

import Tree.Person;

public class ComparByChild<E extends Person> implements Comparator<E>{

    @Override
    public int compare(E person1, E person2) {
        if (person2.getChildrens().size() == person1.getChildrens().size()) {
            return 0;
        } else if (person2.getChildrens().size() > person1.getChildrens().size()) {
            return 1;
        }
        else{
            return -1;}
    }
}
