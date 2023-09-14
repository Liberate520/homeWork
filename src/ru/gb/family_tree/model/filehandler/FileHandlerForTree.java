package ru.gb.family_tree.model.filehandler;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.filehandler.firstsave.FileHandler;
import ru.gb.family_tree.model.human.Human;

public class FileHandlerForTree extends FileHandler implements Writable{
    private String filePath = "tree.out";

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean write(FamilyTree<Human> tree) {
        return super.write(tree, filePath);
    }

    @Override
    public FamilyTree<Human> read() {
        return (FamilyTree<Human>)super.read(filePath);
    }
}
