package oop.familyTree.tree;

import oop.familyTree.human.Human;
import oop.familyTree.human.HumanComparatorByAge;
import oop.familyTree.human.HumanNode;
import oop.familyTree.workOfFields.FieldDate;
import oop.familyTree.workOfFields.FieldGender;
import oop.familyTree.workOfFields.FieldHuman;
import oop.familyTree.workOfFields.FieldName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<V extends HumanNode> implements Serializable, Iterable<Map.Entry<String, V>> {
    private final long SerialVersionUID = 1L;
    private Map<String, V> currentTree;

    /**
     * Конструктор
     */
    public FamilyTree(){
        this.currentTree = new LinkedHashMap<>();
    }

    /**
     * Получение объекта Human из древа для работы с ним.
     * Если будет создан другой класс, для которого можно создать родословное древо,
     * тогда подобный метод будет создан и для него.
     * @param fullName полное имя
     * @return объект типа Human
     */
    @SuppressWarnings("unchecked")
    public Human getHumanByFullName(String fullName){
        return (Human) currentTree.getOrDefault(fullName, (V) new Human());
    }

    /**
     * Добавление нового человека
     * @param fullName имя человека
     * @param gender пол
     * @param dateOfBirth дата рождения
     * @param dateOfDeath дата смерти
     * @param mother имя матери
     * @param father имя отца
     * @param spouse имя супруга
     * @param children имена детей
     */
    @SuppressWarnings("unchecked")
    public void addNewHuman(String fullName, String gender,
                            LocalDate dateOfBirth, LocalDate dateOfDeath,
                            String mother, String father,
                            String spouse, String children) {
        Human human = new Human(fullName, gender,
                dateOfBirth, dateOfDeath, mother, father, spouse, children);
        this.currentTree.putIfAbsent(human.getFullName(), (V) human);
    }

    /**
     * Удаление человека из древа
     * @param fullName имя человека
     */
    public String deletingHuman(String fullName){
        for (Map.Entry<String, V> human : this.currentTree.entrySet()){
            if (human.getKey().equals(fullName)) {
                currentTree.remove(human.getKey());
                return "Человек удалён из древа";
            }
        }
        return "Такого человека в древе нет";
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
    public String fullInfoHuman(String fullName){
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
        currentTree.forEach((String, V) -> System.out.println(V));
    }

    /**
     * Сортировка по возрасту, с использованием
     * своего компаратора
     */
    public void sortByAge(){
        Map<String, V> sortedMap = new TreeMap<>(new HumanComparatorByAge<>(currentTree));
        sortedMap.putAll(currentTree);
        sortedMap.forEach((String, human) -> System.out.println(human));
    }

    /**
     * Изменение значения поля
     * @param treeName имя древа
     * @param fullName имя человека
     * @param numField номер поля
     * @param newValue новое значение
     */
    @SuppressWarnings("unchecked")
    public void changeValueField(String treeName, String fullName, int numField, String newValue){
        switch (numField){
            case 1 -> {
                Human human = new FieldName().changeField(treeName, fullName, numField, newValue);
                currentTree.remove(fullName);
                currentTree.putIfAbsent(newValue, (V) human);
            }
            case 2 -> {
                Human human = new FieldGender().changeField(treeName, fullName, numField, newValue);
                currentTree.computeIfPresent(fullName, (String, V) -> (V) human);
            }
            case 3, 4 -> {
                Human human = new FieldDate().changeField(treeName, fullName, numField, newValue);
                currentTree.computeIfPresent(fullName, (String, V) -> (V) human);
            }
            case 5, 6 -> {
                Human human = new FieldHuman().changeField(treeName, fullName, numField, newValue);
                currentTree.computeIfPresent(fullName, (String, V) -> (V) human);
            }
            case 7 -> {
                Human human = this.getHumanByFullName(fullName);
                human.setSpouse(newValue);
            }
            case 8 -> {
                Human human = this.getHumanByFullName(fullName);
                human.setChild(newValue);
            }
        }
    }

    @Override
    public Iterator<Map.Entry<String, V>> iterator() {
        return currentTree.entrySet().iterator();
    }
}
