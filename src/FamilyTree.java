import java.io.*;
import java.util.*;
import java.util.function.Consumer;


public class FamilyTree <E> implements Serializable, Iterable<Human> {
    List<E> familyTree;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }
    public FamilyTree() {
        this(new ArrayList<E>());
    }

    public void addElement (E element) {
        this.familyTree.add(element);
    }

    public void save (String filepath) throws IOException {
        FileHandler fh = new FileHandler();
        fh.save((Serializable) familyTree, filepath);
    }

    public void load (String filepath) throws IOException, ClassNotFoundException {
        FileHandler fh = new FileHandler();
        fh.load(filepath);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator((List<Human>) familyTree);
    }

    public void sortByName () {
        Collections.sort((List<Human>) familyTree);
    }
    public void sortBySex () {
        familyTree.sort((Comparator<? super E>) new HumanComparatorBySex());
    }

}
