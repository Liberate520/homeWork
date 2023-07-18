package familyTree.Human.Comporator;
import familyTree.FamilyTreeItem;
import familyTree.Human.Human;

import java.util.Comparator;

public class humanComporatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    private int pass;

    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
