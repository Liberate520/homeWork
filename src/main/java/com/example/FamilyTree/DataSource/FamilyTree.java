package com.example.FamilyTree.DataSource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<HumanFamily> humanFamilyList;

    public FamilyTree() {
        humanFamilyList = new ArrayList<>();
    }

    public void addHumanFamilyList(HumanFamily humanFamily) {
        humanFamilyList.add(humanFamily);
    }

    public void save(String path){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(path, this);
    }

    public FamilyTree read(String path){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(path);
    }

    public HumanFamily getHumanFamilyList(int index) {
        return humanFamilyList.get(index);
    }
}
