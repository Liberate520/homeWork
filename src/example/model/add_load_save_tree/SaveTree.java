package org.example.model.add_load_save_tree;

import org.example.model.Human;
import org.example.model.Tree;
import org.example.model.file.TreeHandlerTXT;

import java.io.IOException;

public class SaveTree {
    private final Tree <Human> tree;

    public SaveTree(Tree<Human> tree) {
        this.tree = tree;
    }

    public void saveTree() throws IOException {
        new TreeHandlerTXT().write(tree);
    }

}
