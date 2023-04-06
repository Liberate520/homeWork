import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


public class FamilyTree implements Serializable, Iterable<Human> {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addPerson (Human human) {
        this.familyTree.add(human);
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
        return new HumanIterator(familyTree);
    }

    public void sortByName () {
        Collections.sort(familyTree);
    }
    public void sortBySex () {
        familyTree.sort(new HumanComparatorBySex());
    }

}
