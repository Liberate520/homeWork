import java.util.*;
import java.io.Serializable;


public class FamilyTree<T extends UserParametrized> implements Serializable, Iterable<T> {   //<T> == <UserParametrized> == Human
    private List<T> listHuman;
    // T t;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> listHuman) {
        this.listHuman = listHuman;
    }

    public boolean add(T human) {
        if (human == null) {
            return false;
        }
        if (!listHuman.contains(human)) {
            listHuman.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human); // если в переданом хумане есть отец/мать, то добавляется ребенок к
                                                   // этим родителям
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for (T human : listHuman) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfoTree() {
        StringBuilder sb = new StringBuilder();
        for (T human : listHuman) {
            sb.append(human.getInfo());
        }
        return sb.toString();
    }

    // создаем Итератор, но нужен отдельный класс, в котором интерфейс Итератор, в нем - что перебрать, добавляем методы hasNext+next
    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(listHuman);  // или return listHuman.iterator();  - стандартный для Листа итератор
    }

    public void sortByName() {
        // Collection.sort(listHuman, new HumanComparatorByName());  // не работает Коллекция??
        listHuman.sort(new HumanComparatorByName<T>());
    }

    public void sortBySizeChildren() {
        // Collection.sort(listHuman, new HumanComparatorBySizeChildren()); // не работает Коллекция??
        listHuman.sort(new HumanComparatorBySizeChildren<T>());

    }
}
