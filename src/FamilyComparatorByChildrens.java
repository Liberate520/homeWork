import java.util.Comparator;
public class FamilyComparatorByChildrens<T extends FamilyGroup> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());

    }
}
