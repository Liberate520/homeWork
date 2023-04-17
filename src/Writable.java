package src;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public interface Writable {
    public abstract void load();
    public abstract void read();
    public void save(HashSet<Human> familyTree) throws IOException;
}
