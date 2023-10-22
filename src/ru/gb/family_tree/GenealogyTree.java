package ru.gb.family_tree;

import ru.gb.family_tree.person.Person;

import java.util.ArrayList;
import java.util.List;

public class GenealogyTree {
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