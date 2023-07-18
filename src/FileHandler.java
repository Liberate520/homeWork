import java.io.*;

public class FileHandler implements FileIO {
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree = (FamilyTree) ois.readObject();
        }
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
}
