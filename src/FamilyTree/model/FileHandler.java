package FamilyTree.model;

import java.io.*;
public class FileHandler implements FileService {
    public boolean save(String path, Serializable savedTree) {
        if (savedTree == null)
        {
            return false;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(savedTree);
            objectOutputStream.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            return false;
        }
        catch (IOException e)
        {
            return false;
        }

    }

    public Serializable load(String path, String type) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            if (type.equals("FamilyTree")) {
                FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
                objectInputStream.close();
                return familyTree;
            }
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
        catch (IOException e)
        {
            return null;
        }
        catch (ClassNotFoundException e)
        {
            return null;
        }

        return null;
    }
}
