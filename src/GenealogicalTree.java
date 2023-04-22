import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GenealogicalTree<E extends Human> implements Serializable, Iterable<E>{
   private List<E> family;

    public GenealogicalTree(List<E> family) {
        this.family = family;
    }

    public GenealogicalTree() {
        this(new ArrayList<>());
    }

    public List<String> getFamily() {
        List<String> result = new ArrayList<>();
        for (E item:
             family) {
            result.add(String.format("%s %d - %d", item.getName(), item.getBirthday(), item.getDeathDay()));
        }
        return result;
    }
    public void addHuman(E human){
        family.add(human);
    }

    public E findHuman(String name) {

        for (E item :
                family) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;

    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<E>(family);
    }

    public void sort(){
        Collections.sort(family);
    }

    public void sortByName(){
        family.sort(new ComparatorByName());
    }
}
