import java.util.Comparator;

public class HumanComporator<T extends HumanItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthYear() - o2.getBirthYear();
    }
    
}
