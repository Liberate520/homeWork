package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import Comparator.CompareByDateOfBirth;
import Comparator.CompareByName;

public class FamilyTree<T extends Person> implements Serializable , Iterable<T> {
    private ArrayList <T> ancestry;

    public FamilyTree() {
        this.ancestry= new ArrayList<T>();
    }
    public void add(T curPer){
        this.ancestry.add(curPer);
    }
    public T getByName(String name){
        for (T human : ancestry){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }    
    public T getByIndex(Integer index){
        for (T human : ancestry){
            if (index--==0){
                return human;
            }
        }
        return null;
    }
    //печать списка персон
    public String showAllPerson(){
        StringBuilder sb = new StringBuilder();
        Integer count=0;
        sb.append("Список :\n");
        Iterator<T> human = ancestry.iterator();
        while  (human.hasNext()){
            sb.append(++count+". "+human.next()+'\n');
        }
        return sb.toString();

    }
    public String showPerson(Integer cur){
        return ancestry.get(cur).toString()+'\n';

    }
    public String сhildrentoSring(Integer cur){
        return ancestry.get(cur).сhildrentoSring() + '\n';

    }
    public void setFather(int cur, Person fat){
        ancestry.get(cur).setFather(fat);
    }
  
    public void setMother(int cur, Person mot){
        ancestry.get(cur).setMother(mot);
    }

    public void addChild(int cur, Person chil){
        ancestry.get(cur).addChild(chil);
    }    
    public void delChild(int cur, int chil){
        ancestry.get(cur).delChild(chil);
    }
    public void CompareByName() {
        ancestry.sort(new CompareByName());
    }
    public void CompareByDateOfBirth() {
        ancestry.sort(new CompareByDateOfBirth());
    }
    @Override
    public Iterator<T> iterator() {
        return ancestry.iterator();
    }
    
}
