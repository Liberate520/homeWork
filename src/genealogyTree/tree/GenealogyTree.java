package tree;

import java.io.Serializable;
import java.util.*;

import model.Person;
import util.GenealogyTreeIterator;

public class GenealogyTree implements Iterable<Person>, Serializable {
    private Person root;

    public GenealogyTree(Person root) {
        this.root = root;
    }

    // Метод для получения всех детей выбранного человека
    public List<Person> getChildrenOfPerson(Person person) {
        return person.getChildren();
    }

    // Метод для сортировки списка людей по имени
    public List<Person> sortPeopleByName() {
    List<Person> people = getAllPeople();
    people.sort(Comparator.comparing(Person::getName));
    return people;
    }

    // Метод для сортировки списка людей по возрасту
    public List<Person> sortPeopleByAge() {
        List<Person> people = getAllPeople();
        people.sort(Comparator.comparingInt(Person::getAge));
        return people;
    }

    // Метод для получения всех людей в дереве
    private List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        getAllPeopleRecursive(root, people);
        return people;
    }

    // Вспомогательный метод для рекурсивного получения всех людей в дереве
    private void getAllPeopleRecursive(Person person, List<Person> people) {
        people.add(person);
        for (Person child : person.getChildren()) {
            getAllPeopleRecursive(child, people);
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return new GenealogyTreeIterator(root);
    }

}
    

