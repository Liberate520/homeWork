package Data;

import People.Repository;
import Tree.FamilyTree;

import java.io.*;

public class DataRepository implements Repository {

    public void dataOutput(FamilyTree familyTree, String str) {

        File file = new File(str);

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos!=null){
                oos = new ObjectOutputStream(fos);
                oos.writeObject(familyTree);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FamilyTree deserialization(String str){
        File file = new File(str);
        ObjectInputStream ois;
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis!= null){
                ois = new ObjectInputStream(fis);
                FamilyTree familyTree = (FamilyTree) ois.readObject();
                return familyTree;
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new FamilyTree();
    }
}
