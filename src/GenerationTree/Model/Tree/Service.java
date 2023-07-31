package GenerationTree.Model.Tree;

import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import GenerationTree.Model.Person.Structs.Gender;

public interface Service {
    boolean addNewTree(String name) throws FileAlreadyExistsException;

    int addTreeItem(String name, Gender gender, LocalDate dateBirth);

    boolean delTreeItem(int id);

    boolean addChild(int parrentId, int childId);

    boolean saveTree();

    boolean loadTree(String treeName);

    boolean deleteSavedTree(String name);

    List<String> getAllSavedTrees();

    String getTreeName();

    String getItemInfoById(int id);

    Map<Integer, String> getTreeItemsInfo();

    Map<Integer, String> getTreeItemsWithoutCurrentItem(int id);

    void sortByName();

}
