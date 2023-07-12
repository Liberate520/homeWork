package familytree.human.comporatop;
import java.util.Comparator;

import familytree.human.Human;

public class HumanComporatorBySurname implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2){
        return o1.getSurname().compareTo(o2.getSurname());

    }
}
