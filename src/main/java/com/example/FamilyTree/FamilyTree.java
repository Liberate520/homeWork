package com.example.FamilyTree;

import com.example.FamilyTree.DataForTree.Human;
import com.example.FamilyTree.DataForTree.HumanComparatorByBirthday;
import com.example.FamilyTree.DataForTree.HumanComparatorByName;
import com.example.FamilyTree.DataForTree.HumanFamily;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<HumanFamily> {
    static final long serialVersionUID = 1L;
    private List<HumanFamily> humanFamilyList;

    public FamilyTree() {
        humanFamilyList = new ArrayList<>();
    }

    public void addHumanFamilyList(HumanFamily humanFamily) {
        humanFamilyList.add(humanFamily);
    }

    /*public void save(String path){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(path, this);
    }

    public FamilyTree read(String path){
        FileHandler fileHandler = new FileHandler();
        return fileHandler.read(path);
    }*/

    public List<HumanFamily> getHumanFamilyList() {
        return humanFamilyList;
    }

    public HumanFamily getHumanFamily(Human human) {
        for (int i = 0; i < humanFamilyList.size(); i++) {
            if (humanFamilyList.get(i).getHuman().equals(human)) {
                return humanFamilyList.get(i);
            }
        }
        return new HumanFamily(human);
    }

    public void sortByBirthday() {
        humanFamilyList.sort(new HumanComparatorByBirthday());
    }

    public void sortByName() {
        humanFamilyList.sort(new HumanComparatorByName());
    }

    public String printHumansList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (HumanFamily human : humanFamilyList) {
            stringBuilder.append(human.getHuman());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<HumanFamily> iterator() {
        return humanFamilyList.iterator();
    }
}
