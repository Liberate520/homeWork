package Tree;

import java.io.*;

import Tree.interfaces.Writable;

public class Handler implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream("FamilyTree.out"));
        objectOutputStream.writeObject(serializable);

        objectOutputStream.close();
    }

    @Override
    public FamilyTree read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream("FamilyTree.out"));
        Object tree = objectInputStream.readObject();
        objectInputStream.close();
        FamilyTree familyTree = new FamilyTree<>();
        for (Object person: (FamilyTree) tree){
            familyTree.add((Person) person);
        }
        return familyTree;
    }
}
