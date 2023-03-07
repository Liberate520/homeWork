package tree;

import tree.comparate.PersonComparatorByBirth;
import tree.comparate.PersonComparatorByName;

import java.util.*;
import java.io.Serializable;
import java.util.function.Predicate;


public class FamilyTree <T extends Person> implements Serializable, Iterable <T> {
    private List<T> personList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> personList) {
        this.personList = personList;
    }

    public boolean add(T T) {
        if (T == null) {
            return false;
        }
        if (!personList.contains(T)) {
            personList.add(T);
            if (T.getFather() != null) {
                T.getFather().addChild(T);
            }
            if (T.getMother() != null) {
                T.getMother().addChild(T);
            }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for (T T : personList) {
            if (T.getName().equals(name)) {
                return T;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder res = new StringBuilder();
        res.append(personList.size());
        res.append(" objects in the tree: \n");
        for (Person person : personList){
            res.append(person.getInfo());
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(personList);
    }

    public void sortByName() {
        Collections.sort(personList, new PersonComparatorByName());
    }

    public void sortByBirthDate() {
        Collections.sort(personList, new PersonComparatorByBirth());
    }

    public void List() {
        for (T p : personList) {
            System.out.println(p);
        }
    }

    public void search(String search) {
        Predicate<T> dynasty = n -> n.getName().equals(search);
        personList.stream()
                .filter(dynasty)
                .forEach(System.out::println);
    }


}


