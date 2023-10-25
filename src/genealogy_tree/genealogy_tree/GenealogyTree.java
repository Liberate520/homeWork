package genealogy_tree.genealogy_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<T> implements Serializable, Iterable<T> {
    private List<T> people;

    public GenealogyTree() {
        people = new ArrayList<>();
    }

    public void addPerson(T person) {
        if (!people.contains(person)) {
            people.add(person);
            System.out.println("В дерево добавлен: " + person);
        } else {
            System.out.println("Не удалось добавить в дерево дубликат: " + person);
        }
    }

    public List<T> getPeople() {
        return people;
    }

    public List<T> getPeopleSortedBy(Comparator<T> comparator) {
        List<T> sortedPeople = new ArrayList<>(people);
        Collections.sort(sortedPeople, comparator);
        return sortedPeople;
    }

    public void setPeople(List<T> people) {
        this.people = people;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenealogyTreeIterator<T>(people);
    }    
}