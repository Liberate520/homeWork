package family_tree.file_handler;

import family_tree.tree.Tree;

public interface Readable {
    public Tree read(String path);
}
