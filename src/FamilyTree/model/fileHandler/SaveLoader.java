package FamilyTree.model.fileHandler;

import FamilyTree.model.person.Person;
import FamilyTree.model.tree.FamilyTree;

import java.io.Serializable;

public interface SaveLoader {
    boolean save(Serializable serializable, String path);
    FamilyTree<Person> load(String path);
}
