package io;

import java.io.*;

import human.Human;
import tree.FamilyTree;

public class FileHandlerSaver implements DataSave {
    private void saveSer(FamilyTree<Human> familyTree) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.ser"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }


    @Override
            public void saveData(FamilyTree<Human> familyTree) throws IOException, ClassNotFoundException{
            saveSer(familyTree);
            System.out.println("Файл сериализации создан");

    }

}



