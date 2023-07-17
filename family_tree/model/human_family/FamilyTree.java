package family_tree.model.human_family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.humans.Human;
import family_tree.model.humans.comparators.HumanComparatorByName;
import family_tree.model.humans.comparators.HumanComparatorByYear;

public class FamilyTree<T extends HumanItem> implements Iterable<T>, IFamilyTree<T> {
    private List<T> persons;
    private List<Human> humans;
    private HumanPrinter humanPrinter;

    public FamilyTree() {
        this.persons = new ArrayList<>();
        this.humans = new ArrayList<>();
    }

    public void addParent(Human parent) {
        humans.add(parent);
    }

    public void addChild(Human child) {
        humans.add(child);
    }

    public List<T> getAllChildren(CharSequence parent) {
        List<T> children = new ArrayList<>();
        for (T human : persons) {
            if (((HumanItem) human).getParents().contains(parent)) {
                children.add(human);
            }
        }
        return children;
    }

    public void sortByName() {
        persons.sort(new HumanComparatorByName<>());
    }

    public void sortByYear() {
        persons.sort(new HumanComparatorByYear<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(persons);
    }

    @Override
    public void removeHuman(T person) {
        persons.remove(person);
    }

    @Override
    public void updateHuman(T person) {
        int index = persons.indexOf(person);
        if (index != -1) {
            persons.set(index, person);
        }
    }

    @Override
    public List<T> getAllHumans() {
        return persons;
    }

    public String getHumanInfo() {
        return humanPrinter.getHumansInfo();
    }

    @Override
    public void addHuman(T human) {
        persons.add(human);
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

}
