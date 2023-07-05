package com.romanovcopy.gmail.Genealogy.serialization;

import com.romanovcopy.gmail.Genealogy.interfaces.writerSerializable;

import java.io.*;

public class WriteStream implements writerSerializable {
    private String path;

    public WriteStream(String path) {
        this.path = path;
    }

    /**
     * запись объекта на диск
     * @param obj
     * @return
     */
    public boolean write(Object obj) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта на диск: " + e.getMessage());
            return false;
        }
    }
}
