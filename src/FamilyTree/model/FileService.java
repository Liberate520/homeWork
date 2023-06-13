package FamilyTree.model;

import java.io.Serializable;

public interface FileService {
    boolean save(String path, Serializable savedTree);
    Serializable load(String path, String type);
}
