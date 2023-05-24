package model.data;

import FamilyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable, String fileName) {

        File filePath = new File(fileName);

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            if (fos!=null){
                oos = new ObjectOutputStream(fos);
                oos.writeObject(serializable);
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
    public FamilyTree load(String fileName) {
        File filePath = new File(fileName);
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
