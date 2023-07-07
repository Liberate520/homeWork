package homeWork.FamalyTree;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamalyTree implements Serializable {
    private long humanId;
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
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            addToChildren(human);
            addToParent(human);
            return true;
        }
        return false;
        
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParents(human);
        }
    }

    private void addToParent(Human human){
        for (Human child: human.getParents()){
            child.addChild(human);
        }
    }


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

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public void SaveData(FamalyTree list, File file){
        FileHandler fileHandler = new FileHandler();
        fileHandler.Save(list, file);
    }

    public void LoadDate(FamalyTree list, File file){
        FileHandler fileHandler = new FileHandler();        
        fileHandler.LoadDate(list, file);
    }
}