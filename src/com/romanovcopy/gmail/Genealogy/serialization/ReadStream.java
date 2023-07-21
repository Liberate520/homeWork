package com.romanovcopy.gmail.Genealogy.serialization;

import com.romanovcopy.gmail.Genealogy.interfaces.readerSerializable;

import java.io.*;

public class ReadStream<T> implements readerSerializable {
    String path;

    /**
     * создание потока считывания с диска
     * @param path путь к считываемому файлу
     */
    public ReadStream(String path){
        this.path=path;
    }

    /**
     * считывание объекта с диска
     * @return object или null при ошибке
     */
    @Override
    public T read(String path) {
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            T obj = null;
            Object readObj = objectIn.readObject();
            if (readObj != null && readObj.getClass().isAssignableFrom(obj.getClass())) {
                obj = (T) readObj;
            }
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при считывании объекта с диска: " + e.getMessage());
            throw new RuntimeException("Ошибка при считывании объекта с диска", e);
        }
    }

}
