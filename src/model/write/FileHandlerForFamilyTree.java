package model.write;

import model.familyTree.famTree.FamilyTree;
import model.human.Human;

public class FileHandlerForFamilyTree extends FileHandler implements Writable{
    private String filePath = "tree.out";

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(FamilyTree<Human> tree) {
        return super.save(tree, filePath);
    }

    @Override
    public FamilyTree<Human> read() {
        return (FamilyTree<Human>)super.read(filePath);
    }
}
