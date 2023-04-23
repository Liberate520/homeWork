package Package;

import Package.Tree.Tree;

import java.io.*;

public class Test implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("familyTree.out"));
        Tree familyRestored = (Tree) input.readObject();
        input.close();

        System.out.println(familyRestored);
    }
}
