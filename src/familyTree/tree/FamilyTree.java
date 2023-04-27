package familyTree.tree;

import familyTree.human.Human;
import familyTree.human.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {

    private Map<String, Human> wholeGenus;

    /**
     * Конструктор. Создаёт новое генеалогическое древо
     */
    public FamilyTree(){
        this.wholeGenus = new LinkedHashMap<>();
    }

    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(wholeGenus);
    }

    /**
     * Добавление в древо нового человека
     * Ключ - полное имя
     * @param human новый человек
     */
    public void addNewHuman(Human human) {
        if (human.hashCode() != 0){
            this.wholeGenus.putIfAbsent(human.getFullName(), human);
        }
    }

    /**
     * Демонстрация всех членов древа
     * @return список всех членов древа
     */
    public String showAll() {
        StringBuilder sb = new StringBuilder();
        int id = 1;
        for (Map.Entry<String, Human> human: this.wholeGenus.entrySet()) {
            sb.append(String.format("%d%s", id, human.getValue()));
            id ++;
        }
        return sb + "\n";
    }

    /**
     * Поиск человека по полному имени
     * @param fullName строка вида Фамилия Имя Отчество
     * @return объект Human
     */
    public Human searchHuman(String fullName){
        return this.wholeGenus.getOrDefault(fullName, new Human(""));
    }

    /**
     * Сортировка по имени
     * Используется компаратор по умолчанию
     */
    public void sortByName(){
        wholeGenus = new TreeMap<>(this.wholeGenus);
        System.out.println(this.showAll());
    }

    /**
     * Сортировка по возрасту.
     */
    public void sortByAge(){
        List<Integer> list = new ArrayList<>();
        Map<String, Human> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Human> human : this.wholeGenus.entrySet())
            list.add(human.getValue().getAge());
        Collections.sort(list);
        for (int i : list) {
            for (Map.Entry<String, Human> human : this.wholeGenus.entrySet())
                if (human.getValue().getAge() == i){
                    sortedMap.putIfAbsent(human.getKey(), human.getValue());
                }
        }
        wholeGenus = sortedMap;
        System.out.println(this.showAll());
    }

    /**
     * Сортировка по возрасту вариант 2, с использованием
     * своего компаратора
     */
    public void sortByAge2(){
        Map<String, Human> sortedMap = new TreeMap<>(new HumanComparatorByAge(wholeGenus));
        sortedMap.putAll(wholeGenus);
        int id = 1;
        for (Map.Entry<String, Human> human : sortedMap.entrySet()){
            System.out.printf("%d%s", id, human.getValue());
            id ++;
        }
    }
}
