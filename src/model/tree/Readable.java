package model.tree;

import java.io.IOException;

public interface Readable {
    FamilyTree readTree () throws IOException, ClassNotFoundException;

}
