package ui.commands;

import java.io.IOException;

import ui.Tree;

interface Saveandreadable {
    default void read_info (Tree<Human> o) throws IOException {

    }

    void  print_info(Tree<Human> o) throws IOException;

    abstract void readInfo (Tree family) throws IOException;
}