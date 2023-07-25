// https://gb.ru/lessons/344116

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;   

import java.io.*; // Serializable


public class HumanTree implements Serializable {
    private List <Human> fHumensTree;
    private String fFileName;
    
    
    public HumanTree() { fHumensTree = new ArrayList<Human>(); }  // constructor HumanTree
    
    public HumanTree(List <Human> aHumensTree) {  // constructor HumanTree from List
        fHumensTree = aHumensTree;
    }
    
    public List <Human> addHuman(Human aHumen){  // merge HumanTree with  aList
        if(!fHumensTree.contains(aHumen)){  // only unigue aHumen !!!
            fHumensTree.add(aHumen);
        }
        return fHumensTree;
    }

    
    public List <Human> addHumanTree(List <Human> aHumensTree){  // merge HumanTree with  aList
        for (Human h: aHumensTree){
            this.addHuman(h);
            // if(!fHumensTree.contains(h)){  // only unigue aHumen !!!
            //     fHumensTree.add(h);
            // }
        }  // fHumensTree.addAll(aHumensTree); // test only unigue ???
        return fHumensTree;
    }
    
    public List <Human> getHumans(){
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
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(aFileName));
        
        objectOutputStream.writeObject(fHumensTree);
        objectOutputStream.close();
        
        fFileName = aFileName;
        return "HumanTree save to " + aFileName;
    }
    
    public List <Human> loadFromFile(String aFileName)  throws IOException, ClassNotFoundException    {
        List <Human> aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName));
                
        aHT = (List <Human>) objectInputStream.readObject();
        fHumensTree = aHT;
        objectInputStream.close();
        fFileName = aFileName;
        return aHT;
    }
    
    public List <Human> addFromFile(String aFileName)  throws IOException, ClassNotFoundException    {
        List <Human> aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName));
                
        aHT = (List <Human>) objectInputStream.readObject();
        objectInputStream.close();
        fFileName = aFileName;
        
        for (Human h: aHT){
            this.addHuman(h);
            // if(!fHumensTree.contains(h)){  // only unigue aHumen !!!  ???
            //     fHumensTree.add(h);
            // }
        }  // fHumensTree.addAll(aHumensTree); // test only unigue ???
        
        return fHumensTree;
    }
    
}

