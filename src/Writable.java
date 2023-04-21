package src;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public interface Writable {
    public void read();
    public void save(HashSet<Human> familyTree) throws IOException;
}
