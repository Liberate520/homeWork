package org.example.model.editing.kindred;

import org.example.model.Gender;
import org.example.model.Human;
import org.example.model.Tree;

public class EChildren extends EditorOfRelatives{
    @Override
    public void addRelatives(Integer text,  Integer index, Tree<Human> tree) {
        tree.getBigFamily().get(index).setChildren(tree.getBigFamily().get(text));
        if (tree.getBigFamily().get(index).getGender().equals(Gender.male)){
            tree.getBigFamily().get(text).setFather(tree.getBigFamily().get(index));
        }else {
            tree.getBigFamily().get(text).setMother(tree.getBigFamily().get(index));
        }
    }

    @Override
    public void removeRelatives() {
        System.out.println("В стадии разработки");
    }
}
