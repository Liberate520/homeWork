package homeWork.src.model.writer;

import homeWork.src.model.tree.FamilyTree;

import java.io.*;
import java.util.List;

public class FileHandler implements Writable{
    private String filePath = "src/homeWork/src/model/writer/tree.txt";
    public boolean save(FamilyTree tree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(tree);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

        public FamilyTree read(){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
                return (FamilyTree) objectInputStream.readObject();
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
