package service;

import human.Human;
import tree.Tree;

public interface Service {
    Human find(String st);

    Tree<Human> sortname();

    Tree<Human> sortbirthyear();

    Tree<Human> sortchild();

    Tree<Human> sortid();

    Tree<Human> addhuman(String str);

    Tree<Human> showtr();
}
