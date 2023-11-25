package ru.gb.family_tree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private Map<Human, Children> familyMap;

    public FamilyTree() {
        this.familyMap = new HashMap<>();
    }

    public void addHumanToFamilyTree(Human human, Children children) {
        familyMap.put(human, children);
    }
    public Map<Human, Children> getFamilyMap() {
        return familyMap;
    }
}
