package model.Data;

import model.Tree.FamilyTree;

import java.io.*;

public class DataRepository implements Writable {

    @Override
    public void dataOutput(FamilyTree familyTree, String str) {

        File filePath = new File(str);

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
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

    @Override
    public FamilyTree deserialization(String str){
        File filePath = new File(str);
        ObjectInputStream ois;
        try {
            FileInputStream fis = new FileInputStream(filePath);
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
