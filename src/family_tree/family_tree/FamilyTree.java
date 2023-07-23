package family_tree.family_tree;

import family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList){this.humanList = humanList;}

    public  FamilyTree(){this(new ArrayList<>());}

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
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

    public List<Human> getSiblings(String name){
        Human human = (Human) getByName(name);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    private boolean cheekId(long id){
        if (id >= humansId || id < 0){
            return false;
        }
        for (Human human: humanList){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Human getById(long id){
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public boolean remove(long humansId){
        if (cheekId(humansId)){
            Human del = getById(humansId);
            return humanList.remove(del);
        }
        return false;
    }

    public String getInfo(){
        StringBuilder str = new StringBuilder();
        str.append("в древе ");
        str.append(humanList.size());
        str.append(" объектов: \n");
        for (Human human: humanList){
            str.append(human);
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
