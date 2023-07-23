package GenerationTree.Model.Tree;

import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDate;
import java.util.List;

import GenerationTree.Model.Person.Structs.Gender;

public interface Service {
    void addNewTree(String name) throws FileAlreadyExistsException;

    List<String> getForest();

    void addTreeItem(String name, Gender gender, LocalDate dateBirth);

    boolean saveTree();

    boolean loadTree(String treeName);

    boolean deleteTree(String name);

}
