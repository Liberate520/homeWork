import java.util.Comparator;

public class HumanComparatorByAge <E extends Human> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {  // getBirthDayO
        int result = o1.getBirthDay().compareTo(o2.getBirthDay());
        if (result == 0 ) {
            return  o1.getName().compareTo(o2.getName());
        } else {
            return result;
        }
    }
}
