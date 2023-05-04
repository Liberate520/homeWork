package familyTree.model.tree;

import familyTree.model.human.FamilyTreeNode;
import familyTree.model.human.Human;
import familyTree.model.human.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyTreeNode> implements Serializable, Iterable<T> {

    private Map<String, T> wholeGenus;

    /**
     * Конструктор. Создаёт новое генеалогическое древо
     */
    public FamilyTree(){
        this.wholeGenus = new LinkedHashMap<>();
    }

    @Override
    public Iterator<T> iterator(){
        return new HumanIterator<>(wholeGenus);
    }

    /**
     * Добавление в древо нового человека
     * Ключ - полное имя
     * @param human новый человек
     */
    public void addNewHuman(T human) {
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
        for (Map.Entry<String, T> human: this.wholeGenus.entrySet()) {
            sb.append(String.format("%d%s", id, human.getValue()));
            id ++;
        }
        return sb + "\n";
    }

    /**
     * Получение информации о человеке по полному имени
     * @param fullName строка вида Фамилия Имя Отчество
     * @return строка с данными человека (если таковой имеется)
     */
    public String searchInfoHuman(String fullName){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, T> human : wholeGenus.entrySet()) {
            if (human.getKey().equals(fullName)) {
                return sb.append(human.getValue()).append("\n").toString();
            }
        }
        return sb.append("Такого человека нет.\n").toString();
    }

    /**
     * Получение объекта Human из древа для работы с ним.
     * Если будет создан другой класс, для которого можно создать родословное древо,
     * тогда подобный метод будет создан и для него.
     * @param fullName полное имя
     * @return объект типа Human
     */
    public Human getHumanByFullName(String fullName){
        return (Human) wholeGenus.getOrDefault(fullName, (T) new Human(""));
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
        Map<String, T> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, T> human : this.wholeGenus.entrySet())
            list.add(human.getValue().getAge());
        Collections.sort(list);
        for (int i : list) {
            for (Map.Entry<String, T> human : this.wholeGenus.entrySet())
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
        Map<String, T> sortedMap = new TreeMap<>(new HumanComparatorByAge(wholeGenus));
        sortedMap.putAll(wholeGenus);
        int id = 1;
        for (Map.Entry<String, T> human : sortedMap.entrySet()){
            System.out.printf("%d%s", id, human.getValue());
            id ++;
        }
    }
}
