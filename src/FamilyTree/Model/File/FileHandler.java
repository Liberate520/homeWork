package FamilyTree.Model.File;

import FamilyTree.Model.tree.Tree;
import FamilyTree.Model.tree.TreeAble;

import java.io.*;

public class FileHandler implements Writeable
{



    @Override
    public void save(TreeAble tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Family.tree"));
        objectOutputStream.writeObject((Object) (tree));

        objectOutputStream.close();

    }

    @Override
    public TreeAble load() throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(

                new FileInputStream("Family.tree"));

        TreeAble tree = new  Tree ();



        tree = (TreeAble) objectInputStream.readObject();


        objectInputStream.close();
        return tree;


    }
}
