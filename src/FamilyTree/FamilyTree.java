package FamilyTree;


import Human.Gender;
import Human.Human;

import java.util.List;
import java.util.ArrayList;

public class FamilyTree {
    private long humansId;
    private List<Human> family;

    public FamilyTree(List<Human> family){
        this.family=family;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean addHuman(Human human){
        if(human == null){
            return false;
        }
        if(!family.contains(human)){
            family.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }

    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            if (human.getGender() == Gender.Male) {
                child.addParents(human);
            }
        }
    }

    public List<Human> getSiblings(int id){
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

    public boolean remove(long humansId){
        if (checkId(humansId)){
            Human person = getById(humansId);
            return family.remove(person);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id>= humansId || id<0){
            return false;
        }
        for (Human human:family){
            if(human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Human getById(long id){
        for (Human human:family){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String  getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе ");
        sb.append(family.size());
        sb.append(" человек: \n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
