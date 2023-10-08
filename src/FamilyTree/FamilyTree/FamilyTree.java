package FamilyTree.FamilyTree;

import FamilyTree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private  List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public  boolean add(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public Human getById(long id){
        if (!checkId(id)){
            return null;
        };
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public  List<Human> getSiblings(int id){
        Human human = getById(id);
        if(human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human child: mother.getChildren()){
            if (!child.equals(human)){
                res.add(child);
            }
        }
        for (Human child: mother.getChildren()){
            if (!child.equals(human) && !res.contains(child)){
                res.add(child);
            }
        }
        return res;
    }

    public  List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return  true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return  true;
        } else {
            return false;
        }
    }

    public  boolean remove(long humansId){
        if (checkId(humansId)){
            Human e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }

    private void addToParents(Human human){
        Human mother = human.getMother();
        Human father = human.getFather();
        if (mother != null){
            mother.addChildren(human);
        }
        if (father != null){
            father.addChildren(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    private boolean checkId(long id){
        if (id >= humansId || id < 0) {
            return false;
        }
        for (Human human: humanList){
            if (human.getId() == id){
                return false;
            }
        }
        return false;
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("in tree ");
        stringBuilder.append(humanList.size());
        stringBuilder.append(" objects\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
