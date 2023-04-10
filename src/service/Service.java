package service;

import human.Human;
import tree.FamilyTree;


import java.io.IOException;

public class Service<T> {
    private FamilyTree familyTree;

    public <T extends Human> Service(){
        familyTree = new FamilyTree();
    }

    public void addHuman(T t){
        familyTree.addHuman((Human) t);
    }




}
