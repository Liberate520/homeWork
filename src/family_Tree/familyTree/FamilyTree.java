package family_Tree.familyTree;

import family_Tree.human.Human;
import family_Tree.human.comparators.HumanComparatorByAge;
import family_Tree.human.comparators.HumanComparatorById;
import family_Tree.human.comparators.HumanComparatorByName;
import family_Tree.writer.FileHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private static List<Human> humanList;
//    private int humanId;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public Human getById (int id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getBrotherSister(int id){
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

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public static String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append((humanList.size()));
        sb.append(" элементов: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    public void sortById(){
        humanList.sort(new HumanComparatorById());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

}
