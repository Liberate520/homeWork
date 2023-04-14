package Tree;

import java.io.*;

import Tree.interfaces.Writable;

public class Handler implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("FamalyTree.out"));
        objectOutputStream.writeObject(serializable);

        objectOutputStream.close();
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("FamalyTree.out"));
        Object tree = objectInputStream.readObject();
        objectInputStream.close();
        for (Object person: (FamilyTree) tree){
            System.out.println(person);
        }
        return tree;
    }
}
