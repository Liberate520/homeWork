package family_tree.model.human_family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.humans.comparators.HumanComparatorByName;
import family_tree.model.humans.comparators.HumanComparatorByYear;

public class FamilyTree<T extends HumanItem> implements IFamilyTree<T>, Iterable<T> {
    private List<T> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public List<T> getAllChildren(CharSequence parent) {
        List<T> children = new ArrayList<>();
        for (T human : humans) {
            if (human.getParents().contains(parent)) {
                children.add(human);
            }
        }
        return children;
    }

    public void addHuman(T human) {
        humans.add(human);
    }

    @Override
    public void removeHuman(T human) {
        humans.remove(human);
    }

    @Override
    public void updateHuman(T human) {
        int index = humans.indexOf(human);
        if (index != -1) {
            humans.set(index, human);
        }
    }

    @Override
    public List<T> getAllHumans() {
        return humans;
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди:");
        for (T human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByYear() {
        humans.sort(new HumanComparatorByYear<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humans);
    }

}
