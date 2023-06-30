package Project_MyFamilyTree_MVP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T>{
    private List<T> humans;
    
    
   

    public FamilyTree (){
        humans = new ArrayList<>();  // или this(new ArrayList<>());
    }

    public FamilyTree (List<T> humans){
        this.humans = humans;
    }
    
    public void addHuman (T human){
        humans.add (human);
    }

    public T findHuman(String name){
        for(T human: humans){
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    
    public String getListHuman(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В древе находятся следующие люди: ");
        stringBuilder.append("\n");
        for(T human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return humans.iterator();
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humans.sort(new HumanComparatorByAge<>());
    }
 
}