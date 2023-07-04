package com.romanovcopy.gmail.Genealogy;

import java.io.*;

public class ReadStrem {
    String path;

    /**
     * создание потока считывания с диска
     * @param path путь к считываемому файлу
     */
    public ReadStrem( String path){
        this.path=path;
    }

    /**
     * считывание объекта с диска
     * @return object или null при ошибке
     */
    public Object read() {
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
             Object obj = objectIn.readObject();
             return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при считывании объекта с диска: " + e.getMessage());
            return null;
        }
    }

}
