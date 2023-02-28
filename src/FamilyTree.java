import com.sun.source.tree.BreakTree;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class FamilyTree implements Iterable<Person>, Serializable{
    private List<Person> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<Person> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Person Person) {
        if (Person == null) {

            return false;
        }
        if (!humanList.contains(Person)){
            humanList.add(Person);
            if (Person.getFather() != null){
                Person.getFather().addChild(Person);
            }
            if (Person.getMother() != null){
                Person.getMother().addChild(Person);
            }
            return true;
        }
        return false;
    }
    public Person getByName(int id) {
        for (Person Person: humanList) {
            if (Objects.equals(Person.getId(), id)){
                return Person;
            }
        }
        return null;
    }
    public void Search(String search) { Predicate<Person> dynasty = n -> n.getName().equals(search);
        humanList.stream()
                .filter(dynasty)
                .forEach(System.out::println);
    }
    public void List() {
        System.out.println();
        System.out.println("Генеалогическое древо Романовых: ");
        for (Person p : humanList) {
            System.out.println(p);
        }
    }
    public void sort() {
        Collections.sort(humanList);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(humanList);
    }

}