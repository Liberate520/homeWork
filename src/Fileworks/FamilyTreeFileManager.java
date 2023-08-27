package Fileworks;

import Model.FamilyTree;
import Model.FamilyTreeSerializable;
import Model.Person;

import java.io.*;
import java.util.List;

public class FamilyTreeFileManager implements FamilyTreeSerializable {
    private List<Person> people;

    public FamilyTreeFileManager(List<Person> people) {
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
            people = (List<Person>) inputStream.readObject();
            return new FamilyTree(people); // Возвращает загруженное дерево семьи
        }
    }



}