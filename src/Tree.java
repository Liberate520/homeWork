package OOPjavaTree.src;

import OOPjavaTree.src.Data.Operation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private List<Human> famBranch;

    public Tree(List<Human> famBranch){
        this.famBranch = famBranch;
    }

    public Tree(){
        this(new ArrayList<>());
    }

    public List<Human> getFamBranch() {
        return famBranch;
    }

    public Human getByName(String name){
        for (Human human : famBranch){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!famBranch.contains(human)){
            famBranch.add(human);
                if (human.getFather() != null){
                    human.getFather().addChild(human);
                }
                if (human.getMother() != null){
                    human.getMother().addChild(human);
                }
                return true;
        }
        return false;
    }

    public void saveData(Operation file, Object tree) {
        file.saveData(tree);
    }

    public Object loadData(Operation file) {
        return file.loadData();
    }

    @Override
    public String toString() {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (Human human : getFamBranch()) {
            sb.append(count++).append(": ");
            sb.append(human.toString()).append("\n");
        }
        return sb.toString();
    }
}
