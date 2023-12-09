package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(E human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            addingChildren(human);
            addingParents(human);
        }

    }

    /**
     * Добавление родителям детей:
     * Если у указанного человека есть родители,
     * то этим родителям будет добавлен указанный человек,
     * как ребенок.
     *
     * @param human ребенок
     */
    private void addingChildren(E human) {
        for (E parent : human.getParents()) {
            parent.setChildren(human);
        }
    }

    /**
     * Добавление ребенку родителей:
     * Если у указанного человека есть дети,
     * то этим детям будет добавлен указанный человек,
     * как родитель.
     * @param human родитель
     */
    private void addingParents(E human) {
        for (E child : human.getChildren()) {
            child.getParents();
        }
    }

    public Object getById(Integer id) {
        for (E human : humanList) {
            if (human.getId().equals(id)) {
                return human;
            }
        }
        return humanList;
    }

    public Object getByName(String name) {
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return humanList;
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator(humanList);
    }


    public void sortByName() {
        humanList.sort(new ComparatorByName());
    }

    public void sortByDateBirthday() {
        humanList.sort(new ComparatorByDateBirthday());
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge());
    }


}
