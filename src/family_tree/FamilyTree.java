package family_tree;
import family_tree.HumanIterator;
import human.Human;
import human.HumanComparatorByName;
import human.HumanComparatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int humanId;
    private List<Human> HumanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.HumanList = humanList;
    }

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if(!HumanList.contains(human)){
            HumanList.add(human);
            human.setId(humanId++);

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

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public  boolean setWedding(int humanId1, int humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }

        return false;
    }

    public boolean setWedding(Human human1, Human human2){
        if (human1.getPartner() == null && human2.getPartner() == null){
            human1.setPartner(human2);
            human2.setPartner(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(int humanId1, int humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2){
        if(human1.getPartner() != null && human2.getPartner() != null){
            human1.setPartner(null);
            human2.setPartner(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int humanId){
        if(checkId(humanId)){
            Human e = getById(humanId);
            return HumanList.remove(e);
        }
        return false;
    }

    private boolean checkId(int id){
        return  id < humanId && id >= 0;
    }

    public Human getById(int id){
        for(Human human : HumanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String toString(){
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(HumanList.size());
        sb.append(" объектов: ");
        sb.append("\n");
        for(Human human : HumanList){
            sb.append(human);
            sb.append("\n");
        }

        return sb.toString();
    }

    public void sortByName(){
        HumanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        HumanList.sort(new HumanComparatorByAge());
    }
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(HumanList);
    }


}
