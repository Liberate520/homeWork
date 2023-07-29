package model.FamilyTree;

public interface Writable {

    void save(FamilyTree tree);
    FamilyTree read ();
}
