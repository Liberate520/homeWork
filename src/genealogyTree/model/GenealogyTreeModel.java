package model;

import java.util.List;

public interface GenealogyTreeModel {
    void addPerson(Person parent, Person child);

    List<Person> getChildren(Person person);

    List<Person> getAncestors(Person person);

    List<Person> sortChildrenByName(Person person);

    List<Person> sortAncestorsByName(Person person);
}
