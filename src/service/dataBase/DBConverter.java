package service.dataBase;

import service.classes.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Клас для сохранения базы
 */
public class DBConverter {
    private final DBHandler db;

    private ArrayList<Person> persons;

    private final List<byte[]> dbBytes;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void prepareToSave() {
        for (Person item : this.db) {
            dbBytes.add(itemToBytes(item));
        }
    }

    public void prepareToLoad(Object o){
        try {
            List<byte[]> bytes = (List<byte[]>) o;
            for (byte[] item : bytes) {
                persons.add(bytesToItem(item));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
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

    private Person bytesToItem(byte[] bytes) {
        Person person = null;
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try (ObjectInput in = new ObjectInputStream(bis)) {
            person = (Person) in.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return person;
    }

    public List<byte[]> getDbBytes() {
        return dbBytes;
    }

    public DBConverter(DBHandler db) {
        this.persons = new ArrayList<>();
        this.dbBytes = new ArrayList<>();
        this.db = db;
    }
}
