package treeWorkspace;

import treeWorkspace.FamilyTree;

public interface Writable {
    public void saveTree(FamilyTree tree,String path);
    public Object loadTree(String path);
}
