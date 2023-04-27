import java.util.Comparator;

public class HumanComporatorByAge <T extends FamilyTreeObject> implements Comparator<T>{
    @Override
    public int compare (T o1, T o2){
        return o1.getDateBirthday().compareTo(o2.getDateBirthday());
    }
}
