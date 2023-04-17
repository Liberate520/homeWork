package service;

import java.io.FileNotFoundException;
import java.io.IOException;

import human.Human;
import tree.Tree;

public interface Service {
    Human find(String st);

    Tree<Human> sortname();

    Tree<Human> sortbirthyear();

    Tree<Human> sortchild();

    Tree<Human> sortid();

    boolean addhuman(String str);

    Tree<Human> showtr();

    void savetree() throws FileNotFoundException, IOException;
}
