package FamilyTree.model.FT;

import java.util.Comparator;

public class ComparatorByBirthDate <T extends commonParam> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1.getBirthDate().equals(o2.getBirthDate())) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());    // getAge -> getBirthDate
        }
    }


}
