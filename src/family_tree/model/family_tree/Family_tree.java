package family_tree.model.family_tree;

import family_tree.model.family_tree.human.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Family_tree<T> implements Serializable, Iterable<T> {
    private ArrayList<T> family_tree;

    public Family_tree() {
        this.family_tree = new ArrayList<>();
    }

    public  void AddHuman(T human){
        this.family_tree.add(human);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо семьи:\n");
        for (T human: this.family_tree){
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

    public Human SelectHuman(String snils){
        for (T human: this.family_tree){
            Human thishuman = (Human)human;
            if (thishuman.getSnils().equals(snils)){
                return thishuman;
            }

        }
        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(family_tree);
    }
}
