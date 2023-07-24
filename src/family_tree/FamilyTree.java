package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int id;
    private int humanId;
    private List<Human> humanList;
    public boolean addHuman (Human human){
        if (human==null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            addToParents(human);
            addToChildren(human);

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
        for (Human human:humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    private boolean checkId(long id){
        if(id>=humanId||id<0){
            return false;
        }
        for (Human human:humanList) {
            if(human.getId()==id){
                return true;
            }
        }
        return false;
    }
    public Human getById(long id){
        for (Human human:humanList) {
            if(human.getId()==id){
                return human;
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
}
