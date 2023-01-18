import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String filePath;

    public void setFileName(String file) {
        this.filePath = file;
    }

    public FileHandler() {
        this.filePath = "tree.dat";
    }


    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
            System.out.println("Saved successfully");
        } catch (Exception ex) {
            System.out.println("Can't write a file");
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public FamilyTree read() {
        FamilyTree result = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(filePath));
            System.out.println("Loaded successfully");
            result = (FamilyTree)objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


}