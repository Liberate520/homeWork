package faminly_tree.model.tree;

public interface TreeToService {
    String nextOfKin(FamilyItem human);
    void sortByName();
    void sortByAge();
    void sortByID();
    int getSize();

}
