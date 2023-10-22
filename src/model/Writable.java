package model;

import java.io.IOException;
import java.io.Serializable;


public interface Writable extends Serializable {
    void writeTreeInFile(FamilyTree object) throws IOException;
    FamilyTree readFromFile() throws IOException, ClassNotFoundException;
}