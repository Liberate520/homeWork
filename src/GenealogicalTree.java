import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GenealogicalTree implements Serializable, Iterable<Human>{
   private List<Human> family;

    public GenealogicalTree(List<Human> family) {
        this.family = family;
    }

    public GenealogicalTree() {
        this(new ArrayList<>());
    }

    public List<String> getFamily() {
        List<String> result = new ArrayList<>();
        for (Human item:
             family) {
            result.add(String.format("%s %d - %d", item.getName(), item.getBirthday(), item.getDeathDay()));
        }
        return result;
    }
    public void addHuman(Human human){
        family.add(human);
    }

    public Human findHuman(String name) {

        for (Human item :
                family) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;

    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyIterator(family);
    }

    public void sort(){
        Collections.sort(family);
    }

    public void sortByName(){
        family.sort(new ComparatorByName());
    }
}
