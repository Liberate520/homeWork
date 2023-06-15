package geoTree;
import java.util.Iterator;
import java.util.List;

import person.Person;
/**
 * Реализация собственного итератора для листа
 */
public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> personList;

    /**
     * Конструктор принимающий список людей
     * @param personList - список людей
     */
    public PersonIterator(List<Person> personList) {
        this.personList = personList;
    }
    /**
     * Метод определяющий, как понять у нас, есть ли следующий элемент 
     * или нет, если index меньше чем размер списка, возвращаем true, 
     * когда равен false
     */
    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    /**
     * Метод для возвращения следующего элемента, после увеличиваем индекс на 1
     */
    @Override
    public Person next() {
        return personList.get(index++);
    }
}
