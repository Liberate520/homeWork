package OOPjavaTree.src.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loaded implements Operation {
    @Override
    public Object getUsedFile(Object tree) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("OOPjavaTree/src/Data/person.out"));
            tree = objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Ошибка восстановления сериализации. Не найден класс!");
        }
        return null;
    }
}