package ui;
import java.util.List;

import Tree.Person;
import Tree.Comporators.ComparByAlive;
import Tree.Comporators.ComparByChild;
import Tree.Comporators.ComparByName;
import Tree.Comporators.ComparBySecondName;

public class Sort<E>{
    private List<Person> familytree;

    public Sort(List<Person> personList) {
    }

    /**
     * @param familytree Список семейного древа
     */
    public void PersonSort(List<Person> familytree){
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
