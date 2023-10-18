package ru.gb.family_tree.human.tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class familyTree {
    private int humanId;
    private List<Human> humanList;

    public familyTree (){
        this(new ArrayList<>());
    }

    public familyTree (List<Human> humanList){
        this.humanList = humanList;
    }

    public void addToTheTree(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

//            addToparents(human);
//            addToChildren(human);
        }
    }




}
