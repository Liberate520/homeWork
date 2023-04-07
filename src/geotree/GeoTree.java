package geotree;

import person.Person;
import person.PersonComparatorByAge;
import person.PersonComparatorByName;
import person.PersonIterator;

import java.awt.event.PaintEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class GeoTree<T> implements Serializable, Iterable<T> {

    private final ArrayList<T> tree = new ArrayList<>();

    public ArrayList getTree() {

        return tree;
    }

    public void appendPerson(T person) {

        tree.add(person);
    }
    public void autoAppendChildren(){
        for (T p:tree) {
            if (((Person) p).getFather()!=null){
                ((Person) p).getMother().addChild((Person) p);
            }
            if (((Person) p).getFather()!=null){
                ((Person) p).getFather().addChild((Person) p);
            }
        }
    }
    public void save(Writable saveGeo) throws IOException{
        saveGeo.write(this);
    }

    public void restore(Readable restoreGeo) throws IOException, ClassNotFoundException {
        restoreGeo.read();
    }

    @Override
    public Iterator<T> iterator(){
        return new PersonIterator(tree);
    }
    public void sortByAge() {
        tree.sort((Comparator<? super T>) new PersonComparatorByAge());
    }
    public void sortByName() {
        tree.sort((Comparator<? super T>) new PersonComparatorByName());
    }

}