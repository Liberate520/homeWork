package HW_5;

import java.io.Serializable;
import java.util.*;

/* Создание класса в котором будет хранится весь перечень людей
    и различные методы для работы с этим деревом
    */
public class FamilyTree implements Serializable,Iterable<Human> {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public FamilyTree() {
        this.familyTree = new ArrayList<Human>();
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    // Добавить новый объект Human в лист дерева
    public void add(Human human) {
        if (!familyTree.contains(human)) {
            this.familyTree.add(human);
            if (human.getFather() != null) human.getFather().addChildren(human);
            if (human.getMather() != null) human.getMather().addChildren(human);
        }
    }

    // Поиск человека по Фамилии в дереве
    public List<Human> searchHuman(String lastName) {
        List<Human> searchTemp = new ArrayList<>();
        for (Human item : familyTree) {
            if (item.getLastname().equals(lastName)) searchTemp.add(item);
        }
        return searchTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyTree that = (FamilyTree) o;
        return Objects.equals(familyTree, that.familyTree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyTree);
    }

    @Override
    public String toString() {
        for (Human item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }

    @Override
    public Iterator<Human> iterator() {

        return new HumanIterator(familyTree);
    }

    public void sortByID() {
        familyTree.sort( new HumanComparatorByID());
    }

    public void sortByLastName() {
        familyTree.sort( new HumanComparatorByLastName());
    }
}

