package family_tree.FamilyTree.Model.Tree;

import family_tree.FamilyTree.Model.Person.Comparators.ComparatorByAge;
import family_tree.FamilyTree.Model.Person.Comparators.ComparatorByName;
import family_tree.FamilyTree.Model.Person.TreeModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;


public class FamilyTree<T extends TreeModel<T>> implements Serializable, Iterable<T> {

    private final ArrayList<T> family;
//    private int inn;

    public FamilyTree() {
        family = new ArrayList<>();
//        this.inn = 0;
    }
    public void addPerson(T person) {
//        if (person.getInn() == 0) {
//            this.inn++;
//            person.setInn(this.inn);
//        }
        if (!this.family.contains(person)) {
            this.family.add(person);
        }

        if (person.getChildren() != null) {
            for (T item : person.getChildren())
                if (!this.family.contains(item)) {
                    this.family.add(item);
                }
        }
        if ((person.getFather() != null) && (!this.family.contains(person.getFather()))) {
            this.family.add(person.getFather());
        }
        if ((person.getMother() != null) && (!this.family.contains(person.getMother()))) {
            this.family.add(person.getMother());
        }
    }

    /**
     * удалят объект из дерева, если у него нет связей с другими объектами из дерева (муж, дети, родители)
     *
     * @param person
     */
    public void removePerson(T person) {
        if (this.family.contains(person.getMother()) || this.family.contains(person.getFather())) {
            return;
        } else if ((person.getHusband() != null) && (this.family.contains(person.getHusband()))) {
            return;
        }
        for (T item : person.getChildren()) {
            if (this.family.contains(item)) {
                return;
            }
        }
        this.family.remove(person);
    }

    public T getForInn(int innPers) {
        for (T item : this.family) {
            if (item.getInn() == innPers) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<T> getTree() {
        return this.family;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new PersonIterator(this.family);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    public void sortByName() {
        this.family.sort(new ComparatorByName());
    }

    public void sortByAge() {
        this.family.sort(new ComparatorByAge());
    }

}
