package oop_1;

import oop_1.comparator.PersonComparatorByDate;
import oop_1.comparator.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// класс устанавливает связи между людьми в дереве
public class GeoTree implements Serializable, Iterable<Person> {
    private Writable writable;
    private List<Person> personList;
    // конструктор дерева без параметров
    public GeoTree() {
        this(new ArrayList<>());
    }
    // конструктор дерева с параметрами
    public GeoTree(List<Person> personList) {
        this.personList = personList;
    }
    // геттеры и сеттеры
    public Writable getWritable() {return writable;}

    public void setWritable(Writable writable) {this.writable = writable;}

    public List<Person> getHumanList() {return personList;}

    public void setHumanList(List<Person> personList) {this.personList = personList;}

    // метод добавления человека в дерево
    public void addPerson(Person person) {
        if (person == null) return;
        if (!personList.contains(person)) {
            personList.add(person);
            if (person.getMother() != null) person.getMother().addChild(person);
            if (person.getFather() != null) person.getFather().addChild(person);
        }
    }
    // метод поиска имени в дереве
    public Person getByName(String name) {
        for (Person person : personList) {
            if (person.getFullName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    // метод получения информации о дереве
    public String getInfoTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(personList.size());
        sb.append(" объектов \n");
        for (Person person : personList) {
            sb.append(person.getInfoPerson());
            sb.append("\n");
        }
        return sb.toString();
    }
    // переопределенный метод to string для вывода объекта дерево по умолчанию
    @Override
    public String toString() {
        String list = "";
        for (Person person : personList)
            list += person.toString();
        return list;
    }
    // создаем метод итератора для дерева
    @Override
    public Iterator<Person> iterator() {
        return personList.iterator();
    }
    // метод сортировки по имени с использованием компаратора
    public void sortByNamePerson() {
        personList.sort(new PersonComparatorByName());
    }
    // метод сортировки по возрасту с использованием компаратора
    public void sortByAgePerson() {
        personList.sort(new PersonComparatorByDate());
    }
}