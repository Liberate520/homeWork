package org.example.model.add_remove_human;

import org.example.model.Human;
import org.example.model.Tree;

public class RemoveHuman {

    public void removeHuman(Integer index, Tree<Human> tree){
        tree.getIdStorage().removeID(tree.getBigFamily().get(index).getId());
        tree.getBigFamily().remove(((int)(index)));
    }
}
