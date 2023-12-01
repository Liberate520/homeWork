package Family_Tree.model.Writer;

import Family_Tree.model.Human.Human;
import Family_Tree.model.Tree.FamilyTree;
import Family_Tree.model.Tree.FamilyTreeIterator;
import Family_Tree.model.Tree.TreeNode;

import java.io.*;

public class FileHandler <E extends FamilyTreeIterator<E> & TreeNode<E>> implements Serializable {

    public boolean write(Serializable serializable, String filePath){
        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree<E> read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            FamilyTree<E> tmp = (FamilyTree<E>) objectInputStream.readObject();
            objectInputStream.close();
            return tmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
