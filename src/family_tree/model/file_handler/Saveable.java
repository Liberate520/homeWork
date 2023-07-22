package family_tree.model.file_handler;

import family_tree.model.tree.Tree;

public interface Saveable {
    public void save(Tree family, String familyName);
}
