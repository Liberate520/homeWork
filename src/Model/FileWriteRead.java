package Model;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.FamilyTree.FileWriter;
import Model.home_work_class.Human.Human;

public class FileWriteRead implements WriteRead {
    FileWriter handler;
    String filePath;

    public FileWriteRead(){
        handler = new FileWriter();
        filePath = handler.getDefaultPath();
    }

    @Override
    public boolean fileWriter(String path, FamilyTree<Human> familyTree) {
        if (!path.isEmpty()) {filePath = path;}
        if (familyTree.sizeTree() > 0){
            handler.write(familyTree, filePath);
            return true;
        }
        return false;
    }

    @Override
    public FamilyTree<Human> fileReader(String path) {
        if (!path.isEmpty()) {filePath = path;}
        return handler.read(filePath);
    }
}
