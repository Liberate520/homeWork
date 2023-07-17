package FamilyTree.Model.File;

import FamilyTree.Model.tree.Tree;

import java.io.*;

public class FileHandler implements Writeable
{



    @Override
    public void save(Tree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Family.tree"));
        objectOutputStream.writeObject((Object) (tree));

        objectOutputStream.close();
    }

    @Override
    public Tree load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Family.tree"));
        Tree tree = new  Tree ();

        tree = (Tree) objectInputStream.readObject();

        objectInputStream.close();
        return tree;


    }
}
