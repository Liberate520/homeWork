import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Individual> implements Serializable, Iterable<T> {
    private List<T> humans;
    private Writable fileHandler;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    private FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    public String getChildrenToString(T human) {
        String res = "Дети от родителя " + human.getInfo() + ": ";
        List<T> children = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getFather() == human) {
                children.add(humans.get(i));
            }
        }
        for (int i = 0; i < children.size(); i++) {
            res = res + "\n" + (i + 1) + "). " + children.get(i).getInfo();
        }
        return res;
    }

    public String getAllHumanToString() {
        String res = "Генеологическое дерево: ";
        List<T> list1 = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            list1.add(humans.get(i));
        }
        for (int i = 0; i < humans.size(); i++) {
            res = res + "\n" + (i + 1) + "). " + humans.get(i).getInfo();
        }
        return res;
    }

    public boolean addHuman(T human) {
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for (T human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void save() throws FileNotFoundException {
        fileHandler.save("FamTree.out");
    }

    public void read() throws IOException {
        fileHandler.read();
    }

    public void setFileHandler(Writable fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public Iterator<T> iterator() {

        return new HumanIterator<T>(humans);
    }

    public void sortByName() {
        Collections.sort(humans, new HumanComparatorByName<T>());
    }

    public void sortByYearBirth() {
        Collections.sort(humans, new HumanComparatorByYearBirth<T>());
    }

}
