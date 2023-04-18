package tree;

import java.io.IOException;
import java.util.List;

public interface Writeble {
    public abstract void load();
    public abstract void read();
    public void save(List<Human> familyTree) throws IOException;
}
