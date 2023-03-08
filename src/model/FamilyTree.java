package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree implements Serializable , Iterator<Person> {
    private ArrayList <Person> Ancestry;
    private int index;

    public FamilyTree() {
        this.Ancestry= new ArrayList<Person>();
    }
    public void add(Person curPer){
        this.Ancestry.add(curPer);
    }
    public Person getByName(String name){
        for (Person human : Ancestry){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }    
    public Person getByIndex(Integer index){
        for (Person human : Ancestry){
            if (index--==0){
                return human;
            }
        }
        return null;
    }
    //печать списка персон
    public String ShowAllPerson(){
        StringBuilder sb = new StringBuilder();
        Integer count=0;
        // for (Person human : Ancestry){
        //     sb.append(++count+". "+human+'\n');
        // }
        Iterator<Person> human = Ancestry.iterator();
        while  (human.hasNext()){
            sb.append(++count+". "+human.next()+'\n');
        }

        return sb.toString();

    }
    public void setFather(int cur, Person fat){
        Ancestry.get(cur).setFather(fat);
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return Ancestry.size()<index;
    }
    @Override
    public Person next() {
        // TODO Auto-generated method stub
        return Ancestry.get(++index);
    }


}
