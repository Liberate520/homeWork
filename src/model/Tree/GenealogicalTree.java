package model.Tree;

import model.Elements.ComparatorByName;
import model.Elements.TreeElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GenealogicalTree<E extends TreeElement> implements Serializable, Iterable<E>{
   private List<E> family;

    public GenealogicalTree(List<E> family) {
        this.family = family;
    }


    public GenealogicalTree() {
        this(new ArrayList<>());
    }

    public List<E> getFamily() {
        return family;
    }

    public List<String> getViewFamily() {
        List<String> result = new ArrayList<>();
        for (E item:
             family) {
            result.add(String.format("%s %d - %d", item.getName(), item.getBirthday(), item.getDeathDay()));
        }
        return result;
    }
    public void addElement(E human){
        family.add(human);
    }

    public E findElement(String name) {

        for (E item :
                family) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    public GenealogicalTree<E> getTree(){
        return this;
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(family);
    }

    public void sort(){
        Collections.sort(family);
    }

    public void sortByName(){
        family.sort(new ComparatorByName<>());
    }
    public boolean contains(E element){
        return family.contains(element);
    }
}
