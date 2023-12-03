package Model.home_work_class.Write;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Human;

public class SingletonFileWrite implements WriteRead {
    private static SingletonFileWrite singletonFileWrite;
    public synchronized static SingletonFileWrite getSingletonFileWrite(FileWriter fileWrite){
        if (singletonFileWrite == null){
            singletonFileWrite = new SingletonFileWrite(fileWrite);
        }
        return singletonFileWrite;
    }
    Writeable handler;

    private SingletonFileWrite(Writeable fileWrite){
        handler = fileWrite;
    }

    @Override
    public boolean fileWriter(String path, FamilyTree<Human> familyTree) {
        if (familyTree.sizeTree() > 0){
            if (!path.isEmpty()) {
                handler.write(familyTree, path);
                return true;
            }
            handler.write(familyTree);
            return true;
        }
        return false;
    }

    @Override
    public FamilyTree<Human> fileReader(String path) {
        if (!path.isEmpty()) {return handler.read(path);}
        return handler.read();
    }
}
