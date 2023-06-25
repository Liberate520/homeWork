package model.geoTree;
import java.util.Iterator;
import java.util.List;
/**
 * Реализация собственного итератора для листа
 */
public class PersonIterator<T> implements Iterator<T> {
    private int index;
    private List<T> personList;

    /**
     * Конструктор принимающий список людей
     * @param personList - список людей
     */
    public PersonIterator(List<T> personList) {
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
    public T next() {
        return personList.get(index++);
    }
}
