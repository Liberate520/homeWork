package familyTree;

import java.io.*;

public class FamilyTreeSerializer implements SerializableReader, SerializableWriter{
    @Override
    public <T> T readObject(String filename) throws IOException, ClassNotFoundException {
        T object;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            object = (T) ois.readObject();
        }
        return object;
    }

    @Override
    public <T> void writeObject(T object, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(object);
        }
    }
    public void saveFamilyTree(FamilyTree tree, String filename) throws IOException{
        writeObject(tree, filename);
    }
    public FamilyTree loadFamilyTree(String filename) throws IOException, ClassNotFoundException{
        return readObject(filename);
    }
}