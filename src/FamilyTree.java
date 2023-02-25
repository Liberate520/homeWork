import java.util.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;


public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> listHuman;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> listHuman) {
        this.listHuman = listHuman;
    }

    public boolean add(Human human) {
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

    public Human getByName(String name) {
        for (Human human : listHuman) {
            if (human.getName() == name) {
                return human;
            }
        }
        return null;
    }

    public String getInfoTree() {
        StringBuilder sb = new StringBuilder();
        for (Human human : listHuman) {
            sb.append(human.getInfo());
        }
        return sb.toString();
    }

    // создаем Итератор, но нужен отдельный класс, в котором интерфейс Итератор, в нем - что перебрать, добавляем методы hasNext+next
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(listHuman);  // или return listHuman.iterator();  - стандартный для Листа итератор
    }

    public void sortByName() {
        // Collection.sort(listHuman, new HumanComparatorByName());  // не работает Коллекция??
        listHuman.sort(new HumanComparatorByName());
    }

    public void sortBySizeChildren() {
        // Collection.sort(listHuman, new HumanComparatorBySizeChildren()); // не работает Коллекция??
        listHuman.sort(new HumanComparatorBySizeChildren());

    }
}
