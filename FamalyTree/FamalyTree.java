package homeWork.FamalyTree;

import java.util.ArrayList;
import java.util.List;

public class FamalyTree {
    private int HumanId;
    private List<Human> humanList;


    public FamalyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public FamalyTree(){
        this(new ArrayList<>());
    }

    public boolean addHumman(Human human){
        if (human == null){
            return false;
        }
        if (humanList.contains(human)){
            humanList.add(human);
            human.setId(HumanId++);
            // addToChildren(human);
            return true;
        }
        return false;
        
    }

    // private void addToChildren(Human human){
    //     for (Human child: human.getChildren()){
    //         child.addFather(human);
    //     }
    // }

    public String getHumanInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getHumanInfo();
    }
}