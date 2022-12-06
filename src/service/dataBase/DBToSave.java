package service.dataBase;

import service.classes.Person;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class DBToSave {
    private final DBHandler db;

    private StringBuilder dbBytes;

    public void prepair(){
        for (Person item: this.db) {
            dbBytes.append(Arrays.toString(itemToBytes(item)));
        }
    }

    private byte[] itemToBytes(Object obj){
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(boas)) {
            oos.writeObject(obj);
            return boas.toByteArray();
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
