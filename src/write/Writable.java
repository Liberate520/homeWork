package write;

import familytree.FamilyTree;

import java.io.Serializable;

public interface Writable {
    void defineFileName(String fileName);
    String fileName();

    int fileType();
    String fileTypeDescription();

    void save(Serializable serializable);
    FamilyTree load();
}