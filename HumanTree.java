// https://gb.ru/lessons/344116

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.time.LocalDate;

import java.io.*; // Serializable


public class HumanTree<E extends Human> implements Serializable, Iterable<E> {  // E inheritance Human
    private List <E> fHumensTree;
    private String fFileName;
    
    
    public HumanTree() { fHumensTree = new ArrayList<E>(); }  // constructor HumanTree
    
    public HumanTree(List <E> aHumensTree) {  // constructor HumanTree from List
        fHumensTree = aHumensTree;
    }
    
    public List <E> addHuman(E aHumen){  // merge HumanTree with  aList
        if(!fHumensTree.contains(aHumen)){  // only unigue aHumen !!!
            fHumensTree.add(aHumen);
        }
        return fHumensTree;
    }

    
    public List <E> addHumanTree(List <E> aHumensTree){  // merge HumanTree with  aList
        for (E h: aHumensTree){
            this.addHuman(h);
            // if(!fHumensTree.contains(h)){  // only unigue aHumen !!!
            //     fHumensTree.add(h);
            // }
        }  // fHumensTree.addAll(aHumensTree); // test only unigue ???
        return fHumensTree;
    }
    
    public List <E> getHumans(){
        return fHumensTree;
    }
    
    public String getFilename(){ return fFileName; }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append(this.super.toString());
        if (fFileName != null){
            stringBuilder.append("HumensTree (" + fFileName + ")\n");
        } else {
            stringBuilder.append("HumensTree (файла нет)\n");
        }
        
        stringBuilder.append("Люди :\n");
        
        for (Human h: fHumensTree){
            stringBuilder.append(h);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    

    public String saveToFile(String aFileName)   throws IOException, ClassNotFoundException   {
         //Сериализация в файл с помощью класса ObjectOutputStream
        ObjIO aIO = new ObjIO();
        aIO.writeFile(aFileName, (Serializable) fHumensTree);
         
        // ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        //         new FileOutputStream(aFileName));
        
        // objectOutputStream.writeObject(fHumensTree);
        // objectOutputStream.close();
        
        fFileName = aFileName;
        return "HumanTree save to " + aFileName;
    }
    
    public List <E> loadFromFile(String aFileName)  throws IOException, ClassNotFoundException    {
        List <E> aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT = (List <E>) aIO.readFile(aFileName);
        fHumensTree = aHT;
        fFileName = aFileName;
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
        fFileName = aFileName;
        return fHumensTree;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(fHumensTree);
    }

    public void sortByName(){
        fHumensTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        fHumensTree.sort(new HumanComparatorByAge<>());
    }
    
}

