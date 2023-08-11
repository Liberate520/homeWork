package model.service.FileActions;

import model.Human.Human;
import model.family_tree.FamilyTree;

public class FamilyTreeFileHandler extends FileHandler implements Writable{
    private String filePath = "MyFamilyTree.out";

    @Override
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @Override
    public boolean save(FamilyTree<Human> tree){
        return super.save(tree, filePath);
    }

    @Override
    public FamilyTree<Human> load(){
        return (FamilyTree<Human>)super.load(filePath);
    }
}
