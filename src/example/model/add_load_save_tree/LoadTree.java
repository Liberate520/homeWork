package org.example.model.add_load_save_tree;

import org.example.model.Human;
import org.example.model.Tree;
import org.example.model.file.TreeHandlerTXT;

import java.io.FileNotFoundException;

public class LoadTree {

    private Tree <Human> tree;


    public LoadTree() throws FileNotFoundException {
            this.tree = new TreeHandlerTXT().read("File.txt");

        }



    public Tree<Human> getTree() {
        return tree;
    }

    public void setTree(Tree<Human> tree) {
        this.tree = tree;
    }

}
