package OOPjavaTree.src.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Saved implements Operation {
    @Override
    public Object getUsedFile(Object data) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("OOPjavaTree/src/Data/person.out"));
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            return null;
        } catch (IOException e) {
            System.out.println("Ошибка записи сериализации!");
        }
        return null;
    }
    }
