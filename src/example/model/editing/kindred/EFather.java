package org.example.model.editing.kindred;

import org.example.model.Human;
import org.example.model.Tree;

public class EFather extends EditorOfRelatives{
    @Override
    public void addRelatives(Integer text,  Integer index, Tree<Human> tree) {
        tree.getBigFamily().get(index).setFather(tree.getBigFamily().get(text));
        tree.getBigFamily().get(text).setChildren(tree.getBigFamily().get(index));
    }

    @Override
    public void removeRelatives() {
        System.out.println("В стадии разработки");
    }
}
