package interfaces;
import treeWorkspace.FamilyTree;
public interface Writable {
    void saveTree(FamilyTree tree, String path);
    Object loadTree(String path);
}
