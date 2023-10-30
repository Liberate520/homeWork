package family_Tree.familyTree;

import family_Tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;
    private int humanId;
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }


    public boolean addHuman(Human human){
        if(human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            return true;
        }
        return false;
    }

    public Human getById (int id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getBrotherSister(int id){
        Human human = getById(id);
        if(human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent: human.getParents()){
            for(Human child: parent.getChildren()){
                if(!child.equals(human) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append((humanList.size()));
        sb.append(" элементов: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

}
