package model.saving;

import model.familyTree.FamilyTree;
import model.person.Person;

import java.io.IOException;

public interface Savable {
    void saveFamilyTreeAs(FamilyTree familyTree, String path) throws IOException;
    FamilyTree getFamilyTreeFrom(String path) throws IOException, ClassNotFoundException;

    void savePersonAs(Person person, String path) throws IOException;
    Person getPersonFrom(String path) throws IOException, ClassNotFoundException;
}
