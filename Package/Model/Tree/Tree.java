package Package.Model.Tree;

import Package.Model.Iteration.ComparatorByBirthdate;
import Package.Model.Iteration.ComparatorByName;
import Package.Model.Iteration.ComparatorBySurname;
import Package.Model.Iteration.MemberIterator;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class Tree <E extends Person> implements Serializable, Iterable<E>{
    private List<E> family;

    public Tree() {
        this.family = new ArrayList<>();
    }

    public List<E> getFamily() {
        return family;
    }

    public void addMember(E person) {
        if (!family.contains(person)) {
            family.add(person);
            if (person.getFather() != null){
                person.getFather().addChildren(person);
            }
            if (person.getMother() != null){
                person.getMother().addChildren(person);
            }
        }
    }

    public E setById(Integer id) {
        for (E person: family) {
            if (person.getId().equals(id)) return person;
        }
        return null;
    }

    public String showFamily(){
        StringBuilder sb = new StringBuilder();
        for (E person: family){
            sb.append(person.showInfo());
        }
        return sb.toString();
    }

    public void sortByName(){
        family.sort(new ComparatorByName<>());
    }

    public void sortBySurname(){
        family.sort(new ComparatorBySurname<>());
    }

    public void sortByBirthdate(){
        family.sort(new ComparatorByBirthdate<>());
    }
    @Override
    public Iterator<E> iterator() {
        return new MemberIterator<>(family);
    }

}
