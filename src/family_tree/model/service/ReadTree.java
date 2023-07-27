package family_tree.model.service;

import family_tree.model.tree.Tree;

public class ReadTree {
    FileHandler fileHandler;
    Tree tree;
    public ReadTree() {
        this.fileHandler = new FileHandler();
    }

    public Service read() {
        tree = (Tree)fileHandler.read();
        if (tree.getType() == "Person"){
            return new ServicePerson();
        } else {
            return new ServiceDog();
        }
    }

}
