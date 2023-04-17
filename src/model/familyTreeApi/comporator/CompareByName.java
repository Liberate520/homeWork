package model.familyTreeApi.comporator;
import java.util.Comparator;

import model.familyTreeApi.Human;

public class CompareByName  implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}