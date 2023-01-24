package Model.tree;

import java.io.IOException;

public interface Writable {
    void writeTreeToFile(FamilyTree tree) throws IOException;
    FamilyTree readTreeFromFile(FamilyTree tree);

    void writeCreatureToFile(Creature tree) throws IOException;
//    FamilyTree readCreatureFromFile(Creature tree);
}
