package FT_Project.model.service.FileActions;

import FT_Project.model.Human.Human;
import FT_Project.model.family_tree.FamilyTree;

public class FamilyTreeFileHandler implements FamilyTreeWritable{
    private String filePath = "MyFamilyTree.out";
    private FileHandler fileHandler;

    public FamilyTreeFileHandler(){
        fileHandler = new FileHandler();
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @Override
    public boolean save(FamilyTree<Human> tree){
        return fileHandler.save(tree, filePath);
    }

    @Override
    public FamilyTree<Human> load(){
        return (FamilyTree<Human>)fileHandler.load(filePath);
    }
}
