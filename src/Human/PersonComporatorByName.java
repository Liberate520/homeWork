package Human;

import java.util.Comparator;

public class PersonComporatorByName<N extends GroupItem> implements Comparator<N> {
    @Override
    public int compare(N o1, N o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
