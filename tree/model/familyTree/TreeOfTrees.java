package model.familyTree;

import java.util.HashMap;
import java.util.Map;

import model.handlers.Saveable;

public class TreeOfTrees<T extends FamilyTree> implements Saveable {
    Map<String, T> familyMap;

    public TreeOfTrees(Map<String, T> familyMap) {
        this.familyMap = familyMap;
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInfo'");
    }

    public Map<String, T> getFamilyMap() {
        return familyMap;
    }
}
