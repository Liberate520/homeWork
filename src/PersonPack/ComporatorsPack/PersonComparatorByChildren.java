package PersonPack.ComporatorsPack;

import PersonPack.Person;
import TreePack.TreeItem;

import java.util.Comparator;
import java.util.Map;

public class PersonComparatorByChildren<E extends TreeItem<E>> implements Comparator<Map.Entry<Integer, E>> {
    @Override
    public int compare(Map.Entry<Integer, E> o1, Map.Entry<Integer, E> o2) {
        return o2.getValue().getChildren().size() - o1.getValue().getChildren().size();
    }
}
