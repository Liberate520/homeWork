package ru.gb.fam_tree.family_tree;

import ru.gb.fam_tree.human.Human;
import ru.gb.fam_tree.human.comparators.ComparatorHumansByAge;
import ru.gb.fam_tree.human.comparators.ComparatorHumansByName;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable,Iterable<Human> {
    private long humansId;
    private List<Human> humansList;

    public FamilyTree(List<Human> humanList){
        this.humansList = humanList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humansList.contains(human)){
            humansList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChidrens(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChidrens(Human human){
        for (Human child: human.getChildrens()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if(human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent: human.getParents()){
            for(Human child: parent.getChildrens()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for(Human human: humansList){
            if(human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setDivorce(long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if(human1.getSpouse() != null && human2.getSpouse() != null){
                human1.setSpouse(null);
                human2.setSpouse(null);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long humansId){
        if(checkId(humansId)){
            Human e = getById(humansId);
            return humansList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id){
        if(id >= humansId || id < 0){
            return false;
        }
        for(Human human: humansList){
            if(human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Human getById(long id){
        for(Human human: humansList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In familly tree: ");
        sb.append(humansList.size());
        sb.append(" objects: \n");
        for(Human human: humansList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toString(){
        return getInfo();
    }



    public Iterator<Human> iterator(){
        return new HumanIterator(humansList);
    }

    public void sortByName(){
        humansList.sort(new ComparatorHumansByName());
    }

    public void sortByAge(){
        humansList.sort(new ComparatorHumansByAge());
    }
}
