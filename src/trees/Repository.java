package trees;


import java.io.*;

public class Repository implements Conservation {

    private String path;

    public Repository(String path) {
        this.path = path;
    }

    @Override
    public void saveFile(FamilyTree tree) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(tree);
        } catch (IOException e) {
            System.out.println("Export error");
        }
    }

    @Override
    public FamilyTree loadFile() {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ops = new ObjectInputStream(fis)) {
            return (FamilyTree) ops.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не гони");
        }
        return null;
    }
}
