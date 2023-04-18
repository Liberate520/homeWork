package Tree;
import java.io.Serializable;
import java.util.List;

import Tree.Comporators.ComparByAlive;
import Tree.Comporators.ComparByChild;
import Tree.Comporators.ComparByName;
import Tree.Comporators.ComparBySecondName;

public class Sort<E> {

    private List<E> familytree;

    public Sort(List<E> familytree) {
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
    
}
