package FamilyTree_homework.model.save;


import FamilyTree_homework.model.Humans.Human;
import FamilyTree_homework.model.familyTree.FamilyTree;
import FamilyTree_homework.model.save.base.FileHandler;

public class FileHandlerForFamilyTree extends FileHandler implements Writable{
    private String filePath ="C:/Users/tiliv/IdeaProjects/homeWork/src/FamilyTree_homework/tree.txt";

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
