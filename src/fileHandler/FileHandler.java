package fileHandler;

import familyTree.FamilyTree;
import java.io.*;


public class FileHandler {

    public void treeSerialize(FamilyTree tree){
        try{
            FileOutputStream fos = new FileOutputStream("tree.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tree);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static FamilyTree treeDeserialize(){
        FamilyTree tree = new FamilyTree();
        try{
            FileInputStream fis = new FileInputStream("tree.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tree = (FamilyTree) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException i){
            i.printStackTrace();
        } catch (ClassNotFoundException c){
            System.out.println("NOT FOUND");
            c.printStackTrace();
        }
        return tree;

    }
}
