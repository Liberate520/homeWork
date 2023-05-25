package oop.familyTree.tree;

import oop.familyTree.human.Human;
import oop.familyTree.human.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<V extends Human> implements Serializable, Iterable<V> {

    private final long SerialVersionUID = 1L;
    private Map<String, V> currentTree;

    /**
     * Конструктор
     */
    public FamilyTree(){
        this.currentTree = new LinkedHashMap<>();
    }

    @Override
    public Iterator<V> iterator(){
        return new HumanIterator<>(currentTree);
    }

    /**
     * Получение объекта Human из древа для работы с ним.
     * Если будет создан другой класс, для которого можно создать родословное древо,
     * тогда подобный метод будет создан и для него.
     * @param fullName полное имя
     * @return объект типа Human
     */
    public Human getHumanByFullName(String fullName){
        return currentTree.getOrDefault(fullName, (V) new Human(""));
    }

    /**
     * Добавление в древо нового человека
     * Ключ - полное имя
     * @param human новый человек
     */
    public void addNewHuman(V human) {
        if (human.hashCode() != 0){
            this.currentTree.putIfAbsent(human.getFullName(), human);
        }
    }

    /**
     * Демонстрация всех членов древа
     * @return список всех членов древа
     */
    public List<String> showAll() {
        List<String> list = new ArrayList<>();
        int id = 1;
        for (Map.Entry<String, V> human: this.currentTree.entrySet()) {
            list.add(String.format("%d%s", id, human.getValue()));
            id ++;
        }
        return list;
    }

    /**
     * Получение информации о человеке по полному имени
     * @param fullName строка вида Фамилия Имя Отчество
     * @return строка с данными человека (если таковой имеется)
     */
    public String searchInfoHuman(String fullName){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, V> human : currentTree.entrySet()) {
            if (human.getKey().equals(fullName)) {
                return sb.append(human.getValue()).append("\n").toString();
            }
        }
        return sb.append("Такого человека нет.\n").toString();
    }

    /**
     * Сортировка по имени
     * Используется компаратор по умолчанию
     */
    public void sortByName(){
        currentTree = new TreeMap<>(this.currentTree);
        System.out.println(this.showAll());
    }

    /**
     * Сортировка по возрасту.
     */
    public void sortByAge(){
        List<Integer> list = new ArrayList<>();
        Map<String, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, V> human : this.currentTree.entrySet())
            list.add(human.getValue().getAge());
        Collections.sort(list);
        for (int i : list) {
            for (Map.Entry<String, V> human : this.currentTree.entrySet())
                if (human.getValue().getAge() == i){
                    sortedMap.putIfAbsent(human.getKey(), human.getValue());
                }
        }
        currentTree = sortedMap;
        System.out.println(this.showAll());
    }

    /**
     * Сортировка по возрасту вариант 2, с использованием
     * своего компаратора
     */
    public void sortByAge2(){
        Map<String, V> sortedMap = new TreeMap<>(new HumanComparatorByAge<>(currentTree));
        sortedMap.putAll(currentTree);
        int id = 1;
        for (Map.Entry<String, V> human : sortedMap.entrySet()){
            System.out.printf("%d %s", id, human.getValue());
            id ++;
        }
    }
}
