package oop.familyTree.human;

import java.util.Comparator;
import java.util.Map;

public class HumanComparatorByAge<V extends HumanNode> implements Comparator<String> {
    private final Map<String, V> wholeGenus;

    /**
     * Конструктор
     * @param wholeGenus карта для сортировки
     */
    public HumanComparatorByAge(Map<String, V> wholeGenus){
        this.wholeGenus = wholeGenus;
    }

    /**
     * Переопределение метода compare
     * @param o1 Имя объекта Human1
     * @param o2 Имя объекта Human2
     * @return число -1,0 или 1
     */
    @Override
    public int compare(String o1, String o2) {
        Integer age1 = this.wholeGenus.get(o1).getAge();
        Integer age2 = this.wholeGenus.get(o2).getAge();
        return age1 - age2;
    }
}
