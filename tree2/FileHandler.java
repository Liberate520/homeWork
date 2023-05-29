package homeWork.tree2;



import java.io.*;


public class FileHandler implements FileFormat {

    public void save(FamilyTree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("family.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("family.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }

    @Override
    public void saveToCSV() {

    }

    @Override
    public void saveToJson(String familyTree) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.json"))) {
            String data = "\n" + familyTree;
            oos.writeObject(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveToDB() {

    }
}
