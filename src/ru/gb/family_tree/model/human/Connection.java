package ru.gb.family_tree.model.human;

import java.util.ArrayList;
import java.util.List;

public abstract class Connection<T> implements Connectable{
    private List<T> parents;
    private List<T> children;
    private T father;
    private T mother;
    public Connection(T father, T mother){
        this.father = father;
        this.mother = mother;
        parents = new ArrayList<>();
        if(father != null){
            parents.add(father);
        }
        if(mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public void addParent(T parent) {
        if(!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public void addChild(T child) {
        if(!children.contains(child)) {
            children.add(child);
        }
    }
}
