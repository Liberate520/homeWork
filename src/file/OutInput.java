package file;
import java.io.FileNotFoundException;
import java.io.IOException;

import tree.Tree;

public interface OutInput {
    void save(Tree famailytree) throws FileNotFoundException, IOException;

    Object load() throws ClassNotFoundException, IOException;
}