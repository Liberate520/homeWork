package module.writeAndread;

import module.familystructure.FamilyGroup;

import java.io.*;

public class Filehandler<T extends FamilyGroup<T>> implements Writable {
    @Override
    public void write(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("lib.txt"))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("lib.txt"));
        return objectInputStream.readObject();
    }


}
