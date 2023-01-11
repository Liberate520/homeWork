package Семинар1.homeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sound.sampled.SourceDataLine;
// Делаем класс Tree (где собираются объекты других классов) параметизированным (общим), чтобы можно было добавлять любой объект
public class Tree<T> implements Iterable<T>  {
    
    private ArrayList<T> family;
    
    public Tree(){
        family = new ArrayList<>();
    }
    

// На случай, если нужен результат
public T find_father(List<T> family, T person){
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

public T find_mother(List<T> family, T person){
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

public ArrayList<T> find_sister_and_brother(List<T> family, T person){
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
// На случай, если нужен только вывод
public void print_father(List<T> family, T person){
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
        System.out.println(res);
        
    }
    
}

public void print_mother(List<T> family, T person){
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
        System.out.println(res);
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
        for(T relative : family){
            if((mother_id.equals(relative.getMother_id()) || father_id.equals(relative.getFather_id())) && !person.getPerson_id().equals(relative.getPerson_id())){
                res.add(relative);
            }
        }
    }
    try{
        res.get(0);
        System.out.println(res);
        
    }
    catch (IndexOutOfBoundsException e) {
        System.out.println("Братьев и сестер обнаружить не получилось");
        
    }
    
}




public void age(T person){
    java.util.Date dateNow = new java.util.Date();
    DateFormat formater = new SimpleDateFormat("y");
    Integer year = Integer.parseInt(formater.format(dateNow));
    Integer b_year = Integer.parseInt(person.getBirthDate().substring(6,10));
    Integer res_age = year - b_year;
    System.out.println(res_age);

}

@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
}
@Override
public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return new TreeIterator(family);
}
public void addHuman(T human) {
    family.add(human);
}
public List<T> getHumanList() {
    return family;
}



}
    
