package model.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.group.comparators.HumanComparatorByAge;
import model.group.comparators.HumanComparatorByGender;
import model.group.comparators.HumanComparatorById;
import model.group.comparators.HumanComparatorByName;
import model.human.NodeTree;

public class FamilyTree<T extends NodeTree<T>> implements Groupable<T>, Serializable {
    private List<T> famyliTree;
    public FamilyTree() {
        famyliTree = new ArrayList<>();
    }
    int id = 0;
    public void addHuman(T t) {
        famyliTree.add(t);
        if (t.getMother() != null)
            t.getMother().addChild(t);
        if (t.getFather() != null)
            t.getFather().addChild(t);
    }
    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public T getHumanByName(String name) {
        T findHuman = null;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().equals(name)) {
                findHuman = famyliTree.get(i);
            }
        }
        return findHuman;
    }

    public void findHuman(String findName) {
        boolean find = false;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().contains(findName)) {
                System.out.println(famyliTree.get(i));
                find = true;
            }
        }
        if (!find)
            System.out.println("Такой человек не найден.");
    }
    public List<T> getHumanList() {
        return famyliTree;
    }
    public void sortByName() {
        famyliTree.sort(new HumanComparatorByName<T>());
        ;
    }
    public void sortByAge() {
        famyliTree.sort(new HumanComparatorByAge<T>());
    }

    public void sortByGenderd() {
        famyliTree.sort(new HumanComparatorByGender<T>());
    }

    public void sortById() {
        famyliTree.sort(new HumanComparatorById<T>());
    }
    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(famyliTree);
    }
}