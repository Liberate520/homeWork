package model;
import java.util.Comparator;


public class HumanComparatorByAge<Entity extends Entities> implements Comparator<Entity>{

    @Override
    public int compare(Entity o1, Entity o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
