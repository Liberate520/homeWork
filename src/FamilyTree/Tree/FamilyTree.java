package family_tree.FamilyTree.Tree;

import family_tree.FamilyTree.Person.Comparators.ComparatorByAge;
import family_tree.FamilyTree.Person.Comparators.ComparatorByName;
import family_tree.FamilyTree.Person.Person;
import family_tree.FamilyTree.Tree.PersonIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;


public class FamilyTree implements Serializable, Iterable<Person> {

    private final ArrayList<Person> family;
    private int inn;

    public FamilyTree() {
        family = new ArrayList<>();
        this.inn = 0;
    }

    /**
     * добавление человека в дерево
     *
     * @param person
     */
    public void addPerson(Person person) {
        if (person.getInn() == 0) {
            this.inn++;
            person.setInn(this.inn);
        }
        if (!this.family.contains(person)) {
            this.family.add(person);
        }

        if (person.getChildren() != null) {
            for (Person item : person.getChildren())
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

    //TODO после развода из дерева исключается тот у которого не осталось других связей
    public boolean divorce(Person fPartner, Person sPartner) {
        if (fPartner.divorce(sPartner)) {
            // пробуем удалить обоих партнеров (в функции удаления прописана проверка на оставшиеся связи)
            this.removePerson(fPartner);
            this.removePerson(sPartner);
            return true;
        }
        return false;
    }

    /**
     * заключение брака
     *
     * @param fPartner
     * @param sPartner
     */
    public void marriage(Person fPartner, Person sPartner) {

        if (fPartner.marriage(sPartner)) {
            if (!this.family.contains(fPartner)){
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
    public void removePerson(Person person) {
        if (this.family.contains(person.getMother()) || this.family.contains(person.getFather())) {
            return;
        } else if ((person.getHusband() != null) && (this.family.contains(person.getHusband()))) {
            return;
        }
        for (Person item : person.getChildren()) {
            if (this.family.contains(item)) {
                return;
            }
        }
        this.family.remove(person);
    }


    //TODO в процессе разработки и ТЕСТА.
    public String getAllTreeStr() {

        if (this.family == null) {
            return "";
        } else {
            StringBuilder info = new StringBuilder();
            for (Person item : this.family) {
                info.append(item.toString());
                info.append("\n");
            }
            return new String(info);
        }
    }

    public HashSet<String> getFullInfoTree() {
        HashSet<String> result = new HashSet<String>();
        for (Person item : this.family) {
            result.add(item.getFullInfo());
        }
        return result;
    }

    public Person getForInn(int innPers) {
        for (Person item : this.family) {
            if (item.getInn() == innPers) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Person> getTree() {

        return this.family;
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(this.family);
    }

    @Override
    public void forEach(Consumer<? super Person> action) {
        Iterable.super.forEach(action);
    }

    public void sortByName() {
        this.family.sort(new ComparatorByName());
    }

    public void sortByAge() {
        this.family.sort(new ComparatorByAge());
    }

}
