package com.javacourse.Family_tree;
import java.util.*;

public class FamilyList<T extends Person>{
    private HashMap<String, T> tree;

    public FamilyList(){
        this.tree = new HashMap<>();
    }
    
    ArrayList<T> sorted_map;

    public boolean add(T human){
        if(! tree.containsKey(human.getName())){
            if (tree.containsValue(human.getDad()) && tree.containsValue(human.getMom())){
                tree.put(human.getName(), human);

                human.getDad().children.add(human.getName());
                human.getMom().children.add(human.getName());
            }
            else if (tree.containsValue(human.getDad())){
                tree.put(human.getName(), human);
                human.getDad().children.add(human.getName());
            }
            else if (tree.containsValue(human.getMom())){
                tree.put(human.getName(), human);
                human.getMom().children.add(human.getName());
            }
            else {
                tree.put(human.getName(), human);
            }
            return true;
        }
        return false;
    }
    public ArrayList<T> sort_name(){
        sorted_map = new ArrayList<>(tree.values());
        sorted_map.sort(new CompareName<>());
        return sorted_map;
    }
    public ArrayList<T> sort_age(){
        sorted_map = new ArrayList<>(tree.values());
        sorted_map.sort(new CompareAge<>());
        return sorted_map;
    }
    public Set<Map.Entry<String, T>> entrySet(){
        return tree.entrySet();
    }
    public Set<String> keySet(){
        return tree.keySet();
    }
    public Collection<T> values(){
        return tree.values();
    }
    public T get(String k){
        return tree.get(k);
    }

    public void print(){
        System.out.println("\nReceived tree: ");
        if (sorted_map != null){
            for(Person human:sorted_map){
                System.out.println("Self: " + human.getName() + ", Mom: " + human.getMom().getName() + ", Dad: " + human.getDad().getName());
            }
        }
        else{
            for(Person human:tree.values()){
                System.out.println("Self: " + human.getName() + ", Mom: " + human.getMom().getName() + ", Dad: " + human.getDad().getName());
            }
        }
    }

    
    
}

    


