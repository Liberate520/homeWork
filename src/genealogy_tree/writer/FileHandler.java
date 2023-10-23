package genealogy_tree.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import genealogy_tree.genealogy_tree.GenealogyTree;

public class FileHandler implements Writable{
    private String fileName;

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    public Boolean SaveTree(GenealogyTree tree){
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public GenealogyTree LoadTree(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            GenealogyTree tree = (GenealogyTree) objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new GenealogyTree();
    }
}
