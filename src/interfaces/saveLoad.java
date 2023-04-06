package interfaces;

import classes.Tree;

public interface saveLoad {
    void save (Tree treeToSave, String path);
    Tree load (String path);
}
