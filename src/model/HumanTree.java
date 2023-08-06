package src.model;// https://gb.ru/lessons/344116

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HumanTree<E extends Human> implements Serializable, Iterable<E> {  // E inheritance Human
    private List <E> humensTree;
    private String fileName;
    
    
    public HumanTree() { humensTree = new ArrayList<E>(); }  // constructor HumanTree
    
    public HumanTree(List <E> aHumensTree) {  // constructor HumanTree from List
        humensTree = aHumensTree;
    }
    
    public List <E> addHuman(E aHumen){  // merge HumanTree with  aList
        if(!humensTree.contains(aHumen)){  // only unigue aHumen !!!
            humensTree.add(aHumen);
        }
        return humensTree;
    }
    
    public List <E> addHumanTree(List <E> aHumensTree){  // merge HumanTree with  aList
        for (E h: aHumensTree){
            this.addHuman(h);
        }
        return humensTree;
    }
    
    public List <E> getHumans(){
        return humensTree;
    }
    
    public String getFilename(){ return fileName; }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append(this.super.toString());
        if (fileName != null){
            stringBuilder.append("HumensTree (" + fileName + ")\n");
        } else {
            stringBuilder.append("HumensTree (файла нет)\n");
        }
        
        stringBuilder.append("Люди :\n");
        
        for (Human h: humensTree){
            stringBuilder.append(h);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    

    public String saveToFile(String aFileName) {  // throws IOException, ClassNotFoundException
         //Сериализация в файл с помощью класса ObjectOutputStream
        ObjIO aIO = new ObjIO();
        aIO.writeFile(aFileName, (Serializable) humensTree);

        fileName = aFileName;
        return "HumanTree save to " + aFileName;
    }
    
    public List <E> loadFromFile(String aFileName) { //  throws IOException, ClassNotFoundException
        List <E> aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT = (List <E>) aIO.readFile(aFileName);
        humensTree = aHT;
        fileName = aFileName;
        return aHT;
    }
    
    public List <E> addFromFile(String aFileName)  throws IOException, ClassNotFoundException    {
        List <E> aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT = (List <E>) aIO.readFile(aFileName);
        for (E h: aHT){
            this.addHuman(h);
        }  
        fileName = aFileName;
        return humensTree;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humensTree);
    }

    public void sortByName(){
        humensTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humensTree.sort(new HumanComparatorByAge<>());
    }


    public E getByName(String humanName) {
        for (E human : humensTree) {
            if (human.getName().equalsIgnoreCase(humanName)) {
                return human;
            }
        }
        return null;
    }

}

