package model;

public interface Writable {
    void save(FamilyTree tree);
    Object read();
}