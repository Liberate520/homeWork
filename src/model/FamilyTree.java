package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem<E>> implements Tree<E> {
    private List<E> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        humanList.add(human);
    }

    public void addHuman(String name, LocalDate date, Gender gender){
        Human newHuman = new Human();
        newHuman.setName(name);
        newHuman.setDateOfBirth(date);
        newHuman.setGender(gender);
        humanList.add((E)newHuman);
    }

    public E getByName(String name){
        for(E item : humanList){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

}
