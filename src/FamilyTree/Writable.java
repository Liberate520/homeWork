package FamilyTree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    public void Save(String filename, FamilyTree saved) throws IOException;
    public FamilyTree Load(String filename) throws IOException, ClassNotFoundException;
}
