package ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import ui.commands.Human;
import ui.commands.Serialisible;


public class Tree<T extends Human> implements Serialisible<T>  {
    
    private ArrayList<T> family;
    
    public T Tree(){
        family = new ArrayList<>();
        return null;
    }


public T find_father( T person){
    T res = null;
    String father_id = person.getFather_id();
    if(father_id == null){
        System.out.println("Отца нет");
        
    }
    else{
        for(T relative : family){
            if(father_id.equals(relative.getPerson_id())){
                res = relative;
            }
        }
        
    }
    return res;

}

public T find_mother(T person){
    T res = null;
    String mother_id = person.getMother_id();
    if(mother_id == null){
        System.out.println("Матери нет");
        
    }
    else{
        for(T relative : family){
            if(mother_id.equals(relative.getPerson_id())){
                res = relative;
            }
        }
        
    }
    return res;

}

public ArrayList<T> find_sister_and_brother(T person){
    ArrayList<T> res = new ArrayList<>();
    String mother_id = person.getMother_id();
    String father_id = person.getFather_id();
    if(mother_id == null && father_id == null){
        System.out.println("Установить не возможно");
    }
    else{
        for(T relative : family){
            if((mother_id.equals(relative.getMother_id()) || father_id.equals(relative.getFather_id())) && !person.getPerson_id().equals(relative.getPerson_id())){
                res.add(relative);
            }
        }
    }
    try{
        res.get(0);
        return res;
    }
    catch (IndexOutOfBoundsException e) {
        System.out.println("Братьев и сестер обнаружить не получилось");
        return res;
    }

}
public void print_father( T person){
    T res = null;
    String father_id = person.getFather_id();
    if(father_id == null){
        System.out.println("Отца нет");
        
    }
    else{
        res = find_father(person);
        System.out.println("Отец:\n" + res);
        
    }
    
}

public void print_mother( T person){
    T res = null;
    String mother_id = person.getMother_id();
    if(mother_id == null){
        System.out.println("Матери нет");
        
    }
    else{
        res = find_mother(person);
        System.out.println("Мать:\n" + res);
    }
    

}


public void print_sister_and_brother( T person){
    ArrayList<T> res = new ArrayList<>();
    String mother_id = person.getMother_id();
    String father_id = person.getFather_id();
    if(mother_id == null && father_id == null){
        System.out.println("Установить не возможно");
    }
    else{
        res = find_sister_and_brother(person);
    }
    try{
        res.get(0);
        System.out.println("Братья и сестры:\n" + res);
        
    }
    catch (IndexOutOfBoundsException e) {
        System.out.println("Братьев и сестер обнаружить не получилось");
        
    }
    
}




public void age(){
    java.util.Date dateNow = new java.util.Date();
    DateFormat formater = new SimpleDateFormat("y");
    Integer year = Integer.parseInt(formater.format(dateNow));
    Human person = null;
    Tree tree = null;
    Integer b_year = Integer.parseInt(person.getBirthDate().substring(6,10));
    Integer res_age = year - b_year;


    System.out.println(res_age);


}

@Override
public void sortByLastname (){
    Tree<Human> tree = null;
    Collections.sort(tree.getHumanList());
}


@Override
public String toString() {

    return getClass().getName() + " " + Integer.toHexString(hashCode());
}


    public void addHuman(T human) {
    family.add(human);
}
public ArrayList<T> getHumanList() {
    return family;
}


    @Override
    public void Serialise (String filename, Object o) throws FileNotFoundException, IOException {

    }

    @java.lang.Override
    public Object Out (String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        return null;
    }

    @java.lang.Override
    public void SerialiseList (String filename, ArrayList<Object> list) throws FileNotFoundException, IOException {

    }

    @java.lang.Override
    public ArrayList<Object> OutList (String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        return null;
    }


    public void setFamily (ArrayList<T> family) {
        this.family = family;
    }
}