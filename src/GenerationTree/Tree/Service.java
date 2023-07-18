package GenerationTree.Tree;

import java.time.LocalDate;

import GenerationTree.Person.Structs.Gender;

public interface Service {
    void addTreeItem(String name, Gender gender, LocalDate dateBirth);

    boolean saveTree();

    boolean loadTree();

}
