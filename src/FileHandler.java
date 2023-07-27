import java.io.*;

public class FileHandler<T extends Serializable> implements FileIO {
    private FamilyTree<T> familyTree;

    public FileHandler(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree = (FamilyTree<T>) ois.readObject();
        }
    }

    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }
}
