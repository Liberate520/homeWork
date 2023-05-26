package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.human.FamilyTreeItem;
import tree.human.comparators.HumanComparatorByAge;
import tree.human.comparators.HumanComparatorByGender;
import tree.human.comparators.HumanComparatorByName;

public class FamilyTree<T extends FamilyTreeItem> implements Serializable, Iterable<T>{
    private List<T> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(T human){
        humanList.add(human);
    }

    public T getHumanByName(String name){
        for (T human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    // public List<T> getFamilyTreeByName(String name){
    //     List<T> res = new ArrayList<>();
    //     res.add(getHumanByName(name));
    //     res.add(getHumanByName(name).getFather());
    //     res.add(getHumanByName(name).getMother());
    //     res.addAll(getHumanByName(name).getBrothersAndSisters());
    //     res.addAll(getHumanByName(name).getGrandParents());
    //     return res;
    // }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (T human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
        // return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());;
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortByGender(){
        humanList.sort(new HumanComparatorByGender<>());
    }
}
