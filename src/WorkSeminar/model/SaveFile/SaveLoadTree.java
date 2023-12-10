package WorkSeminar.model.SaveFile;

import java.io.*;

public class SaveLoadTree implements ReadLoadable {

    public void saveFile(String path, Serializable serializable) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(path))) {
            outputStream.writeObject(serializable);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Не удалась запись файла" + ex);
        } catch (IOException ex) {
            throw new RuntimeException("Не удалась запись файла" + ex);
        }
    }

    public Object loadFile(String path) {
        try(ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            return inputStream.readObject();

        } catch (FileNotFoundException | ClassNotFoundException ex) {
            throw new RuntimeException("Не удалось чтение файла: \n" + ex);
        } catch (IOException ex) {
            throw new RuntimeException("Не удалось чтение файла: \n" + ex);
        }
    }
}
