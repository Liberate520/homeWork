package model.human;
import java.util.Comparator;

public class HumanComporatorByName<T extends FamilyTreeObject> implements Comparator<T>{
    @Override
    public int compare (T o1, T o2){
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
