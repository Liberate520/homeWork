package Model.home_work_class.Write;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Human;

import java.io.*;

public class FileWriter implements Writeable {
    private String path;

    public FileWriter(String path) {
        this.path = path;
    }
    public FileWriter() {
        this("");
        this.path = getDefaultPath();
    }
    public void write(FamilyTree<Human> tree) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.path));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void write(FamilyTree<Human> tree, String path){
        this.path = path;
        this.write(tree);
    }

    public FamilyTree<Human> read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.path));
            FamilyTree tree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return new FamilyTree<>();
        }
    }

    public FamilyTree<Human> read(String path){
        this.path = path;
        return this.read();
    }

    public String getDefaultPath(){return "tree.out";}
}