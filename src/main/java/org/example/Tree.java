package org.example;

import java.util.ArrayList;

public class Tree {
    private String nameFamily;
    private final ArrayList<Human> bigFamily;
    {
        bigFamily = new ArrayList<>();
    }


    public String getNameFamily() {
        return nameFamily;
    }

    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    public ArrayList<Human> getBigFamily() {
        return bigFamily;
    }

    public void addHuman(Human human){
        this.bigFamily.add(human);
    }

}
