package src;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;

public class FileRW implements Writable, Readable {

    public boolean saveFile(Object data, @NotNull String path) throws IOException {
        String fileName = path.concat(".bin");
        boolean flag = true;
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public Object loadFile(@NotNull String path) throws IOException, ClassNotFoundException {
        String fileName = path.concat(".bin");
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
