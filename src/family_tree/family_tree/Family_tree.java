package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.human.HumanComparatorByDate;
import family_tree.human.HumanComparatorByFam;
import family_tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family_tree implements Serializable, Iterable<Human> {
    private ArrayList<Human> family_tree;

    public Family_tree() {
        this.family_tree = new ArrayList<>();
    }

    public  void AddHuman(Human human){
        this.family_tree.add(human);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо семьи:\n");
        for (Human human: this.family_tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        family_tree.sort(new HumanComparatorByName());
    }

    public void sortByFam(){
        family_tree.sort(new HumanComparatorByFam());
    }

    public void sortByDr(){
        family_tree.sort(new HumanComparatorByDate());
    }
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(family_tree);
    }
}
