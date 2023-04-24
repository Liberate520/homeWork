package model;

import family.FamilyTree;
import person.Person;

import java.io.IOException;

public interface SaveAndLoad<E extends Person> {
    void save(String filename, FamilyTree<E> tree) throws IOException;

    FamilyTree<E> load(String filename) throws IOException, ClassNotFoundException;
}
