package model;

import java.io.IOException;

public interface Writable {
    boolean output() throws IOException;
    FamilyTree input() throws IOException, ClassNotFoundException;
}