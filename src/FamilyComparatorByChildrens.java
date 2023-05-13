import java.util.Comparator;
public class FamilyComparatorByChildrens<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());

    }
}
