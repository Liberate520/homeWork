package Hw.sem1;

import java.io.*;

class FileHandler implements DataStorage {
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(familyTree);
        }
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTree loadedFamilyTree = (FamilyTree) inputStream.readObject();
            familyTree = loadedFamilyTree;
        }
    }
}

