package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.human.comparator.HumanComparatorByName;
import family_tree.human.comparator.HumanComparatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    public long humansId;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList=humanList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToCildren(human);

            return true;
        }
        return false;
    }
    private void addToParents(Human human){
        for(Human parent:human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToCildren(Human human){
        for(Human child:human.getChildren()){
            child.addParent(human);
        }
    }
    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human==null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent:human.getParents()){
            for (Human child:parent.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }
    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human:humanList){
            if(human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humasId2){
        if(checkId(humanId1) && checkId(humasId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humasId2);
            if(human1.getSpouse() == null&& human2.getSpouse()==null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }else{
                return false;
            }
        }
        return false;
    }
    public boolean setDivorce(long humanId1, long humanId2){
        Human human1=getById(humanId1);
        Human human2=getById(humanId2);
        if (human1.getSpouse()!=null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
        } else {
            return false;
        }
        return false;
    }
    public boolean remove(long humansId){
        if(checkId(humansId)){
            Human e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }
    private boolean checkId(long id){
        if(id>= humansId||id<0){
            return false;
        }
        for (Human human: humanList){
            if (human.getId()==id){
                return true;
            }
        }
        return false;
    }
    public Human getById(long id){
        for (Human human: humanList){
            if (human.getId()==id){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for(Human human:humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    public void sortByName(){
        Collections.sort(humanList,new HumanComparatorByName());
    }

    public void sortByAge(){
        Collections.sort(humanList,new HumanComparatorByAge());
    }
    @Override
    public String toString() {
        return getInfo();
    }


    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }
}
