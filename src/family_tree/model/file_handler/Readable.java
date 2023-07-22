package family_tree.model.file_handler;

import family_tree.model.tree.Tree;

public interface Readable {
    public Tree read(String path);
}
