package tree;

import java.util.ArrayList;
import java.util.List;

public class Children extends Human {

    public List<Human> childrenList;

    public Children() {
        childrenList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        childrenList.add(human);

    }


    public Children(String surName, String name, String secondName, Human father, Human mother, List<Human> childrenList) {
        super(surName, name, secondName, father, mother);
        this.childrenList = childrenList;


    }


}
