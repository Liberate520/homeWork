package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import Comparator.CompareByDateOfBirth;
import Comparator.CompareByName;

public class FamilyTree<T extends Person> implements Serializable , Iterable<T> {
    private ArrayList <T> Ancestry;

    public FamilyTree() {
        this.Ancestry= new ArrayList<T>();
    }
    public void add(T curPer){
        this.Ancestry.add(curPer);
    }
    public T getByName(String name){
        for (T human : Ancestry){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }    
    public T getByIndex(Integer index){
        for (T human : Ancestry){
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
        Iterator<T> human = Ancestry.iterator();
        while  (human.hasNext()){
            sb.append(++count+". "+human.next()+'\n');
        }
        return sb.toString();

    }
    public String showPerson(Integer cur){
        return Ancestry.get(cur).toString()+'\n';

    }
    public String сhildrentoSring(Integer cur){
        return Ancestry.get(cur).сhildrentoSring() + '\n';

    }
    public void setFather(int cur, Person fat){
        Ancestry.get(cur).setFather(fat);
    }
    // public Person getFather(int cur){
    //     return Ancestry.get(cur).getFather();
    // }
    public void setMother(int cur, Person mot){
        Ancestry.get(cur).setMother(mot);
    }
    // public Person getMother(int cur){
    //     return Ancestry.get(cur).getMother();
    // }
    public void addChild(int cur, Person chil){
        Ancestry.get(cur).addChild(chil);
    }    
    public void delChild(int cur, int chil){
        Ancestry.get(cur).delChild(chil);
    }
    public void CompareByName() {
        Ancestry.sort(new CompareByName());
    }
    public void CompareByDateOfBirth() {
        Ancestry.sort(new CompareByDateOfBirth());
    }
    @Override
    public Iterator<T> iterator() {
        return Ancestry.iterator();
    }
    
}
