package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import FamilyTree.Iterators.FamilyTreeIterator;
import Human.Human;
import Human.Comporators.HumanComparatorByAge;
import Human.Comporators.HumanComparatorByName;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable,Iterable<E>{
    private long id;
    private List<E> family;
    
    public FamilyTree(List<E> family){
        this.family = family;
    }
    
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean addHuman(E human){
        if(human==null){
            return false;
        }
        if(!family.contains(human)){     
            family.add(human);
            human.setId(id++);
            addToChildren(human);
            addToParents(human);
            return true;
        }
         return false;
    }

    private void addToParents(E human){
        for(E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for(E child: human.getChildren()){
            child.addMother(human);
            child.addFather(human);
        }
    }

    public E getById(long id){
        for(E human: family){
            if(human.getId()==id){
                return human;
            }
        }
        return null;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for(E human: family){
            if(human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public List<E> getSiblings(E human){
        List<E> res = new ArrayList<>();
        if(human==null){
            return null;
        }
        for(E parent: human.getParents()){
            for(E child: parent.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public boolean setWedding(E human1,E human2){
        if(!human1.getGender().equalsIgnoreCase(human2.getGender())){
           if(human1.getSpouse()==null&&human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
           }
        }
        return false;
    }

    public boolean setDivorse(E human1,E human2){
        if(!human1.getGender().equalsIgnoreCase(human2.getGender())){
           if(human1.getSpouse().equals(human2)&&human2.getSpouse().equals(human1)){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
           }
        }
        return false;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("People in the tree: ");
        sb.append(family.size());
        sb.append("\n");
        for(E human: family){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(family);
    }

    public void sortByName(){
        family.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        family.sort(new HumanComparatorByAge<>());
    }
}
