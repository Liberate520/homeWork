package family_tree;

public interface Writable {
    void SaveTree(FamilyTree familyTree, String file_path);
    FamilyTree OpenTree(String file_path);
}
