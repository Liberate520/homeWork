package family_tree;

import human.Human;
import human.HumanIterator;
import human.comparator.ComparatorSortByDateOfBirth;
import human.comparator.ComparatorSortByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem> implements Iterable<E>{
    private int id;
    private int humanId;
    private List<E> humanList;
    public boolean addHuman (E human){
        if (human==null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            addToParents((Human) human);
            addToChildren((Human) human);

            return true;
        }
        return false;
    }


    public FamilyTree(int id){
        this.id = id;
        humanList = new ArrayList<>();
    }


    public String getInfo(){// вывод информации дерева
        StringBuilder sb=new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human:humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    private boolean checkId(long id){
        if(id>=humanId||id<0){
            return false;
        }
        for (E human:humanList) {
            if(human.getId()==id){
                return true;
            }
        }
        return false;
    }
    public Human getById(long id){
        for (E human:humanList) {
            if(human.getId()==id){
                return (Human) human;
            }
        }
        return null;
    }
    public boolean setWedding(long humansId1,long humansId2){
        if(checkId(humansId1)&&checkId(humansId2)){
            Human human1=getById(humansId1);
            Human human2=getById(humansId2);

            if (human1.getSpouse()==null&&human2.getSpouse()==null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }else {
                return false;
            }
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

    @Override
    public String toString(){return getInfo();}
    @Override
    public Iterator<E> iterator(){
        return new HumanIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new ComparatorSortByName<>());
    }
    public void sortByDateOfBirth(){
        humanList.sort(new ComparatorSortByDateOfBirth<>());
    }
}
