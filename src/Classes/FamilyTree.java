package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    public List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public String getInfo() {
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("Дерево содержит персон :");
        tmpSb.append(humanList.size());
        tmpSb.append("\n");
        for (Human human : humanList) {
            tmpSb.append(human.getInfo());
            tmpSb.append("\n");
        }
        return tmpSb.toString();
    }

    public String toString() {
        return getInfo();
    }

    public boolean add(Human human) {
        //       if(human==null){
        //          return false;}
        //      if(humanList.contains(human)){
        humanList.add(human);
        //           addToParents(human);
        //           addToChildren(human);
        //           return true;
        //       }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

//    public Human getByName(String name){
//
//    }
}
