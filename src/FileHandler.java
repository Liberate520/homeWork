import humans.tree.FamilyTree;

import java.io.*;

public class FileHandler implements WorkingWithFiles{

    @Override
    public boolean save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.txt"));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilyTree write() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.txt"));
            return (FamilyTree)objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
