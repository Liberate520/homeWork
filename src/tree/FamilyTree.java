package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.human.Human;
import tree.human.comparators.HumanComparatorByAge;
import tree.human.comparators.HumanComparatorByGender;
import tree.human.comparators.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    // public List<Human> getFamilyTreeByName(String name){
    //     List<Human> res = new ArrayList<>();
    //     res.add(getHumanByName(name));
    //     res.add(getHumanByName(name).getFather());
    //     res.add(getHumanByName(name).getMother());
    //     res.addAll(getHumanByName(name).getBrothersAndSisters());
    //     res.addAll(getHumanByName(name).getGrandParents());
    //     return res;
    // }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
        // return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());;
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    public void sortByGender(){
        humanList.sort(new HumanComparatorByGender());
    }
}
