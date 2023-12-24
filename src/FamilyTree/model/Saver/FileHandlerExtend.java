package FamilyTree.model.Saver;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Human;

public class FileHandlerExtend extends FileHandler implements Writable {
    private String savePath = "src/FamilyTree/model/saver/tree.txt";

    @Override
    public boolean save(FamTree<Human> tree) {
        return super.save(tree, savePath);
    }

    @Override
    public FamTree<Human> read() {
        return (FamTree<Human>)super.load(savePath);
    }

    @Override
    public void setSavePath(String savePath) {
        this.savePath = savePath;


    }
}
