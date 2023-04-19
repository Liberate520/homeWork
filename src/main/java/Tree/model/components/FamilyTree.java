package Tree.model.components;

import Tree.model.comparator.HumanComparatorByDate;
import Tree.model.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// класс работающий с листом семейного дерева
public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> humanList;
    static final long serialVersionUID = 1L;

    // конструкторы
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    // геттеры
    public List<T> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<T> humanList) {
        this.humanList = humanList;
    }

    // метод добавления человека в дерево
    public void add(T human) {
        if (human == null) return;
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) human.getMother().addChild(human);
            if (human.getFather() != null) human.getFather().addChild(human);
        }
    }

    // метод очистки дерева
    public void clearTree() {
        humanList.clear();
    }

    // метод получения экземпляра человек в дереве по имени
    public T getByName(String name) {
        for (T human : humanList) {
            if (human.getFullName().equalsIgnoreCase(name))
                return human;
        }
        return null;
    }

    // метод удаления человека из дерева
    public boolean deletePerson(T human) {
        if (human == null) {
            return false;
        }
        if (humanList.contains(human)) {
            humanList.remove(human);
            if (human.getFather() != null) {
                human.getFather().removeChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().removeChild(human);
            }
            for (Tree.model.components.Human child : human.getChildren()) {
                child.removeMother();
                child.removeFather();
            }
            return true;
        }
        return false;
    }

    // метод получения всех записей в дереве
    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Количество человек в дереве: ").append(humanList.size()).append("\n");
        for (T human : humanList)
            res.append(human.getInfo());
        return res.toString();
    }

    // итератор в интерфейсе Iterable
    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    // метод сортировки по имени
    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    // метод сортировки по дате рождения
    public void sortByAge() {
        humanList.sort(new HumanComparatorByDate<>());
    }
}