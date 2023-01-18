package write;

import familytree.FamilyTree;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable);
    FamilyTree load();
}