package ru.gb.family_tree_homework.family_tree;

import ru.gb.family_tree_homework.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private List<Human> familyTree;
    private int index;

    public HumanIterator(List<Human> familyTree){
        this.familyTree = familyTree;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < familyTree.size();
    }

    @Override
    public Human next(){
        if(hasNext()){
            Human human = familyTree.get(index);
            index++;
            return human;
        } else {
            return null;
        }
    }
}
