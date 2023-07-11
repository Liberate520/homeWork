package ru.gb.family_tree;

public class AddChildAndParent<T extends TreeItem> {

    private void addToParents(T human){
        for (Human parent: human.getParents()){
            parent.addChild((Human) human);
        }
    }
    private void addToChildren(T human){
        for (Human child: human.getChildren()){
            child.addParent((Human) human);
        }
    }
}
