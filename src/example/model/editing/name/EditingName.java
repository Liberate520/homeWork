package org.example.model.editing.name;

import org.example.model.Human;
import org.example.model.Tree;

public class EditingName {
    public  void editingName(String text, Integer index, Tree<Human> tree){
        tree.getBigFamily().get(index).setName(text);
    }
}
