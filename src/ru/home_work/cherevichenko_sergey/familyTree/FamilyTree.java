package ru.home_work.cherevichenko_sergey.familyTree;

import ru.home_work.cherevichenko_sergey.human.*;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    // Класс имеет одно поле с листом
    private ArrayList<Human> humans;

    // В конструкторе инициализируем List как ArrayList
    public FamilyTree() {
        humans = new ArrayList<>();
    }

    // Метод для заполнения ArrayList экземплярами класса ru.home_work.cherevichenko_sergey.human.Human
    public void addHuman(Human human) {
        humans.add(human);
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }

    @Override
    public Iterator iterator() {
        return new HumanIterator(humans);
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















