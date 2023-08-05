package homeWork.ProjectFamilyTree.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family_tree<E extends Family_Tree_Item> implements Serializable, Iterable<E> {
    private List<E> list = new ArrayList<>();
    public void addHuman(E human){list.add(human);}
    public Family_tree(){list = new ArrayList<>();}



    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(list);
    }
    public void sortByAge(){list.sort(new HumanComparatorByAge<>());}
    public void sortByName(){list.sort(new HumanComparatorByName<>());}
}
