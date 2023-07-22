package com.pamihnenkov;

import java.io.*;

public class FileHandler implements Writeable{

    private final String fileName = "backup.txt";
    @Override
    public void save(Serializable serializable) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(serializable);

        } catch (FileNotFoundException e){
            System.err.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка создания потока");
        }
    }

    @Override
    public Object load() {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return ois.readObject();

        } catch (FileNotFoundException e){
            System.err.println("Файл не найден: " + fileName);
            return null;
        } catch (IOException e) {
            System.err.println("Ошибка создания потока");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка приведения типов");
            return null;
        }
    }
}
