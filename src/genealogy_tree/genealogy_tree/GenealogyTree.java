package genealogy_tree.genealogy_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import genealogy_tree.person.Person;

public class GenealogyTree implements Serializable{
    private List<Person> people;

    public GenealogyTree() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
            System.out.println("В дерево добавлен: " + person);
        }else{
            System.out.println("Не удалось добавить в дерево дубликат: " + person);;
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}