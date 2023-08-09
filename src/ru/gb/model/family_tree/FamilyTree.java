package ru.gb.model.family_tree;

import ru.gb.model.human.Human;
import ru.gb.model.human.HumanComparatorByAge;
import ru.gb.model.human.HumanComparatorByName;
import ru.gb.model.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> humans;
    private long humansId;
    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(E human) {
        if (!humans.contains(human)) {
            humans.add(human);
            human.setId(humansId++);
        }
    }

    public long getHumansId() {
        return humansId;
    }

    public E getHumanById(long id) {
        for (E human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    /**
     * Сначала указывается ребенок, потом родитель
     * @param child это ребенок
     * @param parent это родитель
     */

    public String setConnection(long childId, long parentId) {
        E child = getHumanById(childId);
        if (child == null){
            return "Id ребенка не найдено в дереве";
        }
        E parent = getHumanById(parentId);
        if (parent == null){
            return "Id родителя не найдено в дереве";
        }
        parent.addChild(child);
        child.addParent(parent);
        return "Связь успешно установлена";
    }
    public List<E> getParent(E child) {
        return child.getParents();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humans.size());
        sb.append(" объектов: \n");
        for (E human: humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }
    public void sortByName(){
        humans.sort(new HumanComparatorByName<E>());
    }
    public void sortByAge(){
        humans.sort(new HumanComparatorByAge<E>());
    }
}
