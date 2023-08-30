package family_tree.FamilyTree.Tree;

import family_tree.FamilyTree.Person.Comparators.ComparatorByAge;
import family_tree.FamilyTree.Person.Comparators.ComparatorByName;
import family_tree.FamilyTree.Person.TreeModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;


public class FamilyTree<T extends TreeModel<T>> implements Serializable, Iterable<T> {

    private final ArrayList<T> family;
    private int inn;

    public FamilyTree() {
        family = new ArrayList<>();
        this.inn = 0;
    }

    public void addPerson(T person) {
        if (person.getInn() == 0) {
            this.inn++;
            person.setInn(this.inn);
        }
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

//    //TODO после развода из дерева исключается тот у которого не осталось других связей ??? ПОДУМАТЬ как правильно и зачем
//    public boolean divorce(T fPartner, T sPartner) {
//        if (fPartner.divorce(sPartner)) {
//            // пробуем удалить обоих партнеров (в функции удаления прописана проверка на оставшиеся связи)
//            this.removePerson(fPartner);
//            this.removePerson(sPartner);
//            return true;
//        }
//        return false;
//    }


    public void marriage(T fPartner, T sPartner) {

        if (fPartner.marriage(sPartner)) {
            if (!this.family.contains(fPartner)) {
                this.family.add(fPartner);
            }
            if (!this.family.contains(sPartner)) {
                this.family.add(sPartner);
            }
        }
    }


    //TODO в процессе ТЕСТА. удалить можно только запись которая не связана ни с кем из дерева.

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
