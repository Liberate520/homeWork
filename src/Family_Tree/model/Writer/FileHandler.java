package Family_Tree.model.Writer;

import Family_Tree.model.Human.Human;
import Family_Tree.model.Tree.FamilyTree;
import Family_Tree.model.Tree.FamilyTreeIterator;
import Family_Tree.model.Tree.TreeNode;

import java.io.*;

public class FileHandler <E extends FamilyTreeIterator<E> & TreeNode<E>> implements Save<FamilyTree<E>>{

    public boolean write(FamilyTree<E> serializable, String fileName){
        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree<E> read(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTree<E> tmp = (FamilyTree<E>) objectInputStream.readObject();
            objectInputStream.close();
            return tmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
