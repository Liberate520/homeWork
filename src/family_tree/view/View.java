package family_tree.view;

import java.io.Serializable;

public interface View extends Serializable{
    void start();
    void answer(String answer);
    void addToTree();
    void addParents();
    void sortByName();
    void sortByAge();
    void getFamilyTreeInfo();
    void save();
    void load();
    void exit();
}
