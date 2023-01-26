package Model.tree;

import java.io.IOException;

public interface Writable {
    boolean writeTreeToFile(FamilyTree tree) throws IOException;
    FamilyTree readTreeFromFile(FamilyTree tree);

    boolean writeCreatureToFile(Creature tree) throws IOException;
//    FamilyTree readCreatureFromFile(Creature tree);
}
