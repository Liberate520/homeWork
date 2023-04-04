package file;
import java.io.FileNotFoundException;
import java.io.IOException;

import tree.Tree;

public interface OutInput<E> {
    void save(Tree<E> famailytree) throws FileNotFoundException, IOException;

    Object load() throws ClassNotFoundException, IOException;
}