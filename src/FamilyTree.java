package Project_MyFamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{

    public Human human;
    private List<Human> humans;
    
    
   

    public FamilyTree (){
        humans = new ArrayList<>();
    }

    public FamilyTree (List<Human> humans){
        this.humans = humans;
    }
    
    public void addHuman (Human human){
        humans.add (human);
    }

    // public void Childrens (List<Human> childrens){
    //     childrens = new ArrayList<>();
    // }
    
    // public void addChildrens (Human human){
    //     childrens.add (human);
    // }

    public Human findHuman(String name){
        for(Human human: humans){
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    public String getHuman(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Human human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humans.iterator();
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humans.sort(new HumanComparatorByAge());
    }
}