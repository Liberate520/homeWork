package WorkSeminar.SaveFile;

import java.io.*;

public class SaveLoadTree implements ReadLoadable {

    public void saveFile(String path, Serializable serializable) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            outputStream.writeObject(serializable);
            outputStream.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Object loadFile(String path) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream(path));
            Object tree = inputStream.readObject();
            inputStream.close();
            return tree;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
