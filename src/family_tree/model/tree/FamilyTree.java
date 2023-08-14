package family_tree.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

import family_tree.model.human.comparators.HumanComparatorPatronymic;
import family_tree.model.human.comparators.HumanComparatorSurname;
import family_tree.model.human.comparators.HumanComparatorsAge;
import family_tree.model.human.comparators.HumanComparatorsName;

public class FamilyTree<E extends FamilyTreeItem<E, K>, K> implements Serializable, Iterable<E> {
    
    private List<E> family;
    public Object getFamilyList;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    public boolean addHuman(E human) {
        if (!family.contains(human)) {
            family.add(human);
            return true;
        }
        return false;
    }

    public boolean removeHuman(E human) {
        if (family.contains(human)) {
            for (E itrHuman : human.getKinshipList()) {
                removeKinship(itrHuman, human);
            }
            family.remove(human);
        }
        return true;
    }

    public boolean removeKinship(E human, E humanKinship) {
        if (family.contains(human)) {
            human.removeKinship(humanKinship);
            return true;
        }
        return false;
    }

    public E getHumanById(int id) {
        for (E human : family) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getBySibling(E human) {
        if (human == null) {
            return null;
        }
        List<E> temp = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    temp.add(child);
                }
            }
        }
        return temp;
    }

    public List<E> getFamilyList() {
        return family;
    }

    public int getSizeFamily() {
        return family.size();
    }

    public void sortByAge() {
        family.sort(new HumanComparatorsAge<>());
    }

    public void sortByName() {
        family.sort(new HumanComparatorsName<>());
    }

    public void sortBySurname() {
        family.sort(new HumanComparatorSurname<>());
    }

    public void sortByPatronymic() {
        family.sort(new HumanComparatorPatronymic<>());
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%s  %-7s       %s             %s          %s   %s   %s   %s  %s",
                        "id", "Фамилия","Имя","Отчество", "Пол", "Возраст", "Дата рождения", "Дата смерти", "Родители(id)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatter);
        stringBuilder.append("\n");
        for (E human : family) {
            stringBuilder.append(human);
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(family);
    }
    
}