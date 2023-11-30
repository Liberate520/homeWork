package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }
    public FamilyTree(List<Human> familyTree) {
        this.familyTree=familyTree;
    }
    public void addHumanToFamilyTree(Human human) {
        familyTree.add(human);
    }

    public List<Human> getByName(String name){
        List<Human> result = new ArrayList<>();
        for(Human human:familyTree)
        {
            if(human.getName().equals(name)){
                result.add(human);
            }
        }
        return result;
    }
    public List<Human> getFamilyTree() {
        return familyTree;
    }
    @Override
    public String toString() {return GetInfo();}
    public String GetInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо: ");
        sb.append(familyTree.size());
        sb.append(" человек\n");
        for(Human human:familyTree)
        {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

}