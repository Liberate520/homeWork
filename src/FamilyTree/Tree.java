package FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> humanList;
    public Tree() {
        this(new ArrayList<>());
    }
    public Tree(List<Human> humanList) { this.humanList = humanList; }

    public boolean addHuman(Human human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
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

    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    public void addSpouse(Human spouse) { humanList.add(spouse);}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" человек: \n");
        for (Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void addHuman(String string, Gender male, LocalDate of) {
    }
}


    
    


    

