package FamilyTree.Tree.model.FileHander;

import java.io.Serializable;

public interface Writable {


    void save(String path, Serializable obj);

    Serializable load(String path);


}