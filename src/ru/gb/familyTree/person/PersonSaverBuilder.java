package ru.gb.familyTree.person;

import ru.gb.familyTree.tree.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class PersonSaverBuilder {
    private FamilyTree family;
    private List<Person> personList = new ArrayList<>();

    public PersonSaverBuilder setFamily(FamilyTree family) {
        this.family = family;
        return this;
    }

    public PersonSaverBuilder setPersonList(List<Person> personList) {
        this.personList = personList;
        return this;
    }

    public PersonSaver createPersonSaver() {
        return new PersonSaver(family, personList);
    }
}