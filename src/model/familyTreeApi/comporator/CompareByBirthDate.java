package model.familyTreeApi.comporator;
import java.util.Comparator;

import model.familyTreeApi.Human;

public class CompareByBirthDate implements Comparator<Human> {
    
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
