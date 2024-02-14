package model.workingWithFile;


import model.tree.Node;

public interface WorkingFile<E> {
    void load(String file);
    void adding(Node n, String file);



}
