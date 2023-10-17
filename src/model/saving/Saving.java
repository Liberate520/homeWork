package model.saving;

import model.family_tree.FamilyTree;
import model.person.Person;

public interface Saving {
    void save(FamilyTree<Person> familyTree);
    FamilyTree<Person> download(String FileName);
}
