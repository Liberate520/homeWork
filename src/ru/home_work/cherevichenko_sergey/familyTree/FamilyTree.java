package ru.home_work.cherevichenko_sergey.familyTree;
import ru.home_work.cherevichenko_sergey.FamilyTreeItem;
import ru.home_work.cherevichenko_sergey.human.*;
import ru.home_work.cherevichenko_sergey.service_tree.ServiceTree;

import javax.lang.model.element.Element;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
public class FamilyTree<E extends FamilyTreeItem>  implements Serializable, Iterable<E> {
    // Класс имеет одно поле с листом
    private ArrayList<E> humans;
    // В конструкторе инициализируем List как ArrayList
    public FamilyTree() {
        humans = new ArrayList<>();
    }

    // Метод для заполнения ArrayList экземплярами класса ru.home_work.cherevichenko_sergey.human.Human
    public void addHuman(E human) {
        humans.add(human);
    }
    public ArrayList<E> getHumans() {
        return humans;
    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }
    public void sortByName(){
        Collections.sort(humans,new HumanComparatorSortByName());
    }
    public void sortByAge(){
        Collections.sort(humans,new HumansComparatorSortByAge());
    }
    public void sortByLastName(){
        Collections.sort(humans,new HumanComparatorSortByLaatName());
    }
    public void sortByCountChildren(){
        Collections.sort(humans,new HumanComparatorSortByCountChildren());
    }
}















