package family_tree.file_handler;

import family_tree.tree.Tree;

public interface Saveable {
    public void save(Tree family, String familyName);
}
