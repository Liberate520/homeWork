package Package.Tree;

import Package.Iteration.Comparators;
import Package.Iteration.Iterable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tree <E extends Person> implements Serializable, Iterable {
    private List<E> family;

    public Tree() {
        this.family = new ArrayList<>();
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

    public void iterateByName() {
        Collections.sort(family, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    @Override
    public void iterateByBirthdate() {
        Collections.sort(family, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });
    }
}
