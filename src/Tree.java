package org.example;

import java.util.ArrayList;

public class Tree {
    private String nameFamily;
    private ArrayList<Human> bigFamily;


    public String getNameFamily() {
        return nameFamily;
    }

    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    public ArrayList<Human> getBigFamily() {
        return bigFamily;
    }

    public void setBigFamily(ArrayList<Human> bigFamily) {
        this.bigFamily = bigFamily;
    }

    public void addHuman(Human human){
        this.bigFamily.add(human);
    }

}
