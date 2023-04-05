package FamilyTree.comparators;

import FamilyTree.Person;
import java.util.Comparator;

public class ComparatByYoB implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {//можно было бы через Integer, как на семинаре но так интереснее для понимания работы компаратора
        if(o1.getYearOfBirth() < o2.getYearOfBirth())
            return -1;
        if(o1.getYearOfBirth() == o2.getYearOfBirth())
            return 0;
        return 1;
    }    
}
