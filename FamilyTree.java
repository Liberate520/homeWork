package Java_OOP.homeWork;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private String name;
    private List<Human> family;

    public List<Human> getFamily() {
        return family;
    }

    public FamilyTree(String name, List<Human> family) {
        this.name = name;
        this.family = family;
    }

    public void includeInFamily(Human... humans) {
        for (Human h : humans) {
            this.family.add(h);
        }
    }

    public List<Human> searchHuman(String name) {
        List<Human> h = new ArrayList<>();
        for (Human human : family) {
            if (human.getName().equalsIgnoreCase(name))
                h.add(human);
        }
        return h;
    }

    public void save(Writable fh, String path) throws FileNotFoundException, IOException {
        fh.write(path, this);
    }

    public FamilyTree load(Writable fh, String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        return fh.load(path);
    }

    public void sortByName() {
        Collections.sort(family, new HumanComparatorByName());
    }

    public void sortByAge() {
        Collections.sort(family, new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(family);
    }

}
