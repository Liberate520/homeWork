package org.example.model.editing.kindred;

import org.example.model.Human;
import org.example.model.Tree;

public class EMother extends EditorOfRelatives{

    @Override
    public void addRelatives(Integer text,  Integer index, Tree<Human> tree) {
        tree.getBigFamily().get(index).setMother(tree.getBigFamily().get(text));
        tree.getBigFamily().get(text).setChildren(tree.getBigFamily().get(index));
    }

    @Override
    public void removeRelatives() {
        System.out.println("В стадии разработки");
    }
}
