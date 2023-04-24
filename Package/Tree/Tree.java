package Package.Tree;

import Package.Iteration.Iterable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tree implements Serializable, Iterable {
    private List<Person> family;

    public Tree() {
        this.family = new ArrayList<>();
    }

    public void addMember(Person person) {
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

    public Person setById(Integer id) {
        for (Person person: family) {
            if (person.getId().equals(id)) return person;
        }
        return null;
    }

    public String showFamily(){
        StringBuilder sb = new StringBuilder();
        for (Person person: family){
            sb.append(person.showInfo());
        }
        return sb.toString();
    }

    @Override
    public void iterateByName() {
        Collections.sort(family, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    @Override
    public void iterateByBirthdate() {
        Collections.sort(family, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });
    }
}
