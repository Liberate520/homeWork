package service.dataBase;

import service.classes.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/*
Клас для сохранения базы
 */
public class DBToSave {
    private final DBHandler db;

    private final StringBuilder dbBytes;

    public void prepare() {
        for (Person item : this.db) {

            dbBytes.append(Arrays.toString(itemToBytes(item)));
        }
    }

    private byte[] itemToBytes(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(obj); // Вот тут умирает((( Не может записать рекурсивные объекты.
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public String getDbBytes() {
        return dbBytes.toString();
    }

    public DBToSave(DBHandler db) {
        this.db = db;
        this.dbBytes = new StringBuilder();
    }
}
