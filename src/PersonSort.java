import java.util.Iterator;
import java.util.List;

public class PersonSort implements Iterator<Person>{
    private int index;
    private List<Person> familytree;

    /**
     * @param familytree Список семейного древа
     */
    public PersonSort(List<Person> familytree){
        this.familytree = familytree;
    }

    /**
     * Сортировка по Имени
     */
    public void sortByName(){
        familytree.sort(new ComparByName());
    }

    /**
     * Сортировка по Фамилии
     */
    public void sortBySecondName(){
        familytree.sort(new ComparBySecondName());
    }

    /**
     * Сортировка по количеству детей
     */
    public void sortByChild(){
        familytree.sort(new ComparByChild());
    }

    /**
     * Сортировка по нахождению в живых
     */
    public void sortByAlive(){
        familytree.sort(new ComparByAlive());
    }    

    @Override
    public boolean hasNext() {
        return index < familytree.size();
    }

    @Override
    public Person next() {
        return familytree.get(index++);
    }
}
