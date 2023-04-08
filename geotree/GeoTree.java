package homeWork.geotree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import homeWork.person.Person;
import homeWork.person.PersonComparatorByAge;
import homeWork.person.PersonComparatorByName;
import homeWork.person.PersonIterator;

public class GeoTree<T extends Person> implements Serializable, Iterable<T> {

    private final ArrayList<T> tree = new ArrayList<>();

    public ArrayList getTree() {

        return tree;
    }

    public void appendPerson(T person) {

        tree.add(person);
    }
    public void autoAppendChildren(){
        for (T p:tree) {
            if (p.getFather()!=null){
                p.getMother().addChild(p);
            }
            if (p.getFather()!=null){
                p.getFather().addChild(p);
            }
        }
    }


    @Override
    public Iterator<T> iterator(){
        return new PersonIterator(tree);
    }
    public void sortByAge() {
        tree.sort(new PersonComparatorByAge());
    }
    public void sortByName() {
        tree.sort(new PersonComparatorByName());
    }

}