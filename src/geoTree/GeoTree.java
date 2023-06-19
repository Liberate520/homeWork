package geoTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import geoTree.comparators.PersonComparatorByDateOfBirth;
import geoTree.comparators.PersonComparatorByName;

public class GeoTree<T extends GeoTreeItem<T>> implements Serializable, Iterable<T>{
    private List<T> personList;

    public GeoTree() {
        this(new ArrayList<>());
    }

    public GeoTree(List<T> personList) {
        this.personList = personList;
    }

    /**
     * Метод, который добовляет связи предков и наследников, а также является
     * флагом для предотращения ошибки, если такой человек есть и его нельзя
     * добавить в список
     * 
     * @param person - личность претендующая на родство
     * @return - успех проведенной проверки
     */
    public boolean addPerson(T person) {

        if (person == null) {
            return false;
        }

        if (!personList.contains(person)) {
            personList.add(person);

            if (person.getFather() != null) {
                person.getFather().addChild(person);
            }

            if (person.getMother() != null) {
                person.getMother().addChild(person);
            }
            return true;
        }
        return false;
    }

    /**
     * Метод для поиска в списке лисчности по ФИО
     * 
     * @param name       - имя;
     * @param surname    - фамилия;
     * @param patronymic - отчество;
     * @return - возвращает личность или null, если такого нет в списке
     */
    public T getByName(String name, String surname, String patronymic) {

        for (T person : personList) {

            if ((person.getName().equals(name)) &&
                    (person.getSurname().equals(surname)) &&
                    (person.getPatronymic().equals(patronymic))) {
                return person;
            }
        }
        return null;
    }

    /**
     * Вывод информации об объекте генеологическое дерево строкой
     * 
     * @return - toString
     */
    public String getInfo() {
        StringBuilder sInfo = new StringBuilder();
        sInfo.append("В дереве ");
        sInfo.append(personList.size());
        sInfo.append(" объектов: \n");
        for (T person : personList) {
            sInfo.append(person.getInfo());
            sInfo.append("\n");
        }
        return sInfo.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<T>(personList);
    }

    public void sortByName(){
        personList.sort(new PersonComparatorByName<T>());
    }

    public void sortByDateOfBirth(){
        personList.sort(new PersonComparatorByDateOfBirth<T>());
    }
}
