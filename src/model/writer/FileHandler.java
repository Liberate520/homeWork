package model.writer;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.*;

public class FileHandler implements Writable{
    String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

//    private String makeFileName(){
//        Formatter formatter = new Formatter();
//        String str = String.format("%s.out", this.fileName);
//        return str;
//    }

    public void save(FamilyTree familyTree){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(String.format("%s.out", this.fileName)));
            objectOutputStream.writeObject(familyTree);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public FamilyTree<Human> load(){
        FamilyTree<Human> familyTreeRestored;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(String.format("%s.out", this.fileName)));
            familyTreeRestored = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return familyTreeRestored;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
