package Fileworks;

import Model.Tree.*;
import Model.*;
import Model.Tree.FamilyTreeSerializable;

import java.io.*;
import java.util.List;



public class FamilyTreeFileManager {
    public FamilyTreeFileManager() {
        // Конструктор без параметров
    }
    public void saveFamilyTree(FamilyTree<FamilyMember> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(familyTree);
        }
    }

    public FamilyTree<FamilyMember> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<FamilyMember>) inputStream.readObject();
        }
    }

    // Другие методы для работы с файлами

    private List people;

    public FamilyTreeFileManager(List people) {
        this.people = people;
    }




}