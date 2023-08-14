package FamilyTree.Tree.model.FileHander;

import java.io.Serializable;

public interface Writable {


    static void save(String path) {
    }

    static void load(Object path) {
    }

    Serializable load(String path);

    void save(String path, Serializable obj);
}