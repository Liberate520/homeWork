package family_tree.model.human_family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.humans.Gender;
import family_tree.model.humans.comparators.HumanComparatorByName;
import family_tree.model.humans.comparators.HumanComparatorByYear;

public class FamilyTree<T extends HumanItem<T>> implements Iterable<T>, IFamilyTree<T> {
    private List<T> persons;
    private String name;
    private int birthYear;
    private Gender gender;
    private List<T> parents;
    private List<T> children;

    public FamilyTree() {
        this.persons = new ArrayList<>();

    }

    public void addParent(T parent) {
        persons.add(parent);
    }

    public void addChild(T child) {
        persons.add(child);
    }

    public List<T> getAllChildren(CharSequence parent) {
        List<T> children = new ArrayList<>();
        for (T human : persons) {
            if (human.getParents().contains(parent)) {
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

    @Override
    public void addHuman(T human) {
        persons.add(human);
    }
    public String getHumansInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Имя: ").append(name).append("\n");
        sb.append("Год рождения: ").append(birthYear).append("\n");
        sb.append("Гендер: ").append(gender).append("\n");
        sb.append("Родители: ");

        if (parents.isEmpty()) {
            sb.append("Неизвестно");
        } else {
            for (T parent : parents) {
                sb.append(parent).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        sb.append("\n");
        sb.append("Дети: ");
        if (children.isEmpty()) {
            sb.append("Нет");
        } else {
            for (T child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}

