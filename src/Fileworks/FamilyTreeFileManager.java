package Fileworks;

import Model.Tree.FamilyTree;
import Model.Tree.FamilyTreeSerializable;

import java.io.*;
import java.util.List;

public class FamilyTreeFileManager implements FamilyTreeSerializable {
    private List people;

    public FamilyTreeFileManager(List people) {
        this.people = people;
    }

    @Override
    public void saveFamilyTree(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(people);
        }
    }


    public FamilyTree loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            people = (List) inputStream.readObject();
            return new FamilyTree(people); // Возвращает загруженное дерево семьи
        }
    }



}