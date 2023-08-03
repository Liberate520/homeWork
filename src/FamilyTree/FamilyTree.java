package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Human.Human;

public class FamilyTree implements Serializable{
    private long id;
    private List<Human> family;
    
    public FamilyTree(List<Human> family){
        this.family = family;
    }
    
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean addHuman(Human human){
        if(human==null){
            return false;
        }
        //if(!Family.contains(human)){      //Не работает с проверкой
            family.add(human);
            human.setId(id++);
            addToChildren(human);
            addToParents(human);
            return true;
        //}
        // return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addMother(human);
            child.addFather(human);
        }
    }

    public Human getById(long id){
        for(Human human: family){
            if(human.getId()==id){
                return human;
            }
        }
        return null;
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for(Human human: family){
            if(human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getSiblings(Human human){
        List<Human> res = new ArrayList<>();
        if(human==null){
            return null;
        }
        for(Human parent: human.getParents()){
            for(Human child: parent.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public boolean setWedding(Human human1,Human human2){
        if(!human1.getGender().equalsIgnoreCase(human2.getGender())){
           if(human1.getSpouse()==null&&human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
           }
        }
        return false;
    }

    public boolean setDivorse(Human human1,Human human2){
        if(!human1.getGender().equalsIgnoreCase(human2.getGender())){
           if(human1.getSpouse().equals(human2)&&human2.getSpouse().equals(human1)){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
           }
        }
        return false;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("People in the tree: ");
        sb.append(family.size());
        sb.append("\n");
        for(Human human: family){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
