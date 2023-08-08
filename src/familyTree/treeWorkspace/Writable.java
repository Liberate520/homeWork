package familyTree.treeWorkspace;

public interface Writable {
    public void saveTree(FamilyTree tree,String path);
    public Object loadTree(String path);
}
